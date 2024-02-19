package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.Admindto;
import com.demo.model.Admin;
import com.demo.service.IAdminService;


@CrossOrigin("*")
@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired
	private IAdminService aservice;
	
	@GetMapping("/admins")
	public ResponseEntity<List<?>> getallAdmins(){
		return ResponseEntity.ok(aservice.getAdmins());
		
	}
	
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<Admin> getById(@PathVariable int adminId){
		Admin admin=aservice.getAdminById(adminId);
		if (admin!=null)
			return ResponseEntity.ok(admin);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/admin/{username}")
	public ResponseEntity<?> getByUsername(@PathVariable String username){
		Admindto admin=aservice.getAdminByUsername(username);
		if (admin!=null)
			return ResponseEntity.ok(admin);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	
	
	@PostMapping("admins")
	public ResponseEntity<String> insertAdmin(@RequestBody Admin admin){
		aservice.addnewAdmin(admin);
		return ResponseEntity.ok("data added successfully");
		
	}
	@PutMapping("admins/{adminId}")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin){
		aservice.updateById(admin);
		return ResponseEntity.ok("data updated successfully");
		
	}
	@DeleteMapping("/admins/{adminId}")
	public ResponseEntity<String> removeById(@PathVariable int adminId){
		aservice.deleteById(adminId);
		return ResponseEntity.ok("data deleted successfully");
		
	}

}