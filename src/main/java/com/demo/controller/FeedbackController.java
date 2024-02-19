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

import com.demo.model.Feedback;

import com.demo.service.IFeedbackService;


@CrossOrigin("*")
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired
	private IFeedbackService fservice;
	
	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> getallFeedback(){
		List<Feedback> flist=fservice.getAllFeedbacks();
		return ResponseEntity.ok(flist);
		
	}
	
	@GetMapping("/feedbacks/{fId}")
	public ResponseEntity<Feedback> getGsById(@PathVariable int fId){
		Feedback f=fservice.getFeedbackById(fId);
		if (f!=null)
			return ResponseEntity.ok(f);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/feedbacks")
	public ResponseEntity<String> insertFeedback(@RequestBody Feedback feedback){
		fservice.addnewfeedback(feedback);
		return ResponseEntity.ok("Feedback added successfully");
		
	}
	@PutMapping("/feedbacks/{fId}")
	public ResponseEntity<String> updateFeedback(@RequestBody Feedback feedback){
		fservice.updateFeedbackById(feedback);
		return ResponseEntity.ok("Feedback updated successfully");
		
	}
	@DeleteMapping("/feedbacks/{fId}")
	public ResponseEntity<String> removeFeedbackBy(@PathVariable int fId){
		fservice.deleteFeedbackById(fId);
		return ResponseEntity.ok("Feedback deleted successfully");
		
	}

}
