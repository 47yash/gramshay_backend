package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.IAdminService;
import com.demo.service.IGramsevakService;
import com.demo.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IGramsevakService gramsevakService;
	
	@Autowired
	private IAdminService adminService;
	
    static class UserCredentials {
        private String username;
        private String password;

        // Getters and setters

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    
    @PostMapping("/user") 
    public ResponseEntity<String> validateUser(@RequestBody UserCredentials credentials) {
    	boolean isValid = userService.validateUserCredentials(credentials.getUsername(), credentials.getPassword());
            if (isValid) {
                return ResponseEntity.status(HttpStatus.OK).body("User validated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        }
    
    
    @PostMapping("/admin") 
    public ResponseEntity<String> validateAdmin(@RequestBody UserCredentials credentials) {
    	boolean isValid = adminService.validateAdminCredentials(credentials.getUsername(), credentials.getPassword());
            if (isValid) {
                return ResponseEntity.status(HttpStatus.OK).body("Admin validated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        }
    
    
    @PostMapping("/gramsevak") 
    public ResponseEntity<String> validateGramsevak(@RequestBody UserCredentials credentials) {
    	boolean isValid = gramsevakService.validateGramsevakCredentials(credentials.getUsername(), credentials.getPassword());
            if (isValid) {
                return ResponseEntity.status(HttpStatus.OK).body("Gramsevak validated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
            }
        }
    
    
    
    
    
    

}

