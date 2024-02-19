package com.demo.service;

import java.util.List;

import com.demo.model.Feedback;


public interface IFeedbackService {

	List<Feedback> getAllFeedbacks();

	Feedback getFeedbackById(int fId);

	void addnewfeedback(Feedback feedback);

	void deleteFeedbackById(int fId);

	void updateFeedbackById(Feedback feedback);

	

}
