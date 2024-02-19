package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IFeedbackDao;
import com.demo.model.Feedback;

@Service
public class FeedbackService implements IFeedbackService{
	
	@Autowired
	private IFeedbackDao fdao;
	

	@Override
	public List<Feedback> getAllFeedbacks() {
		// TODO Auto-generated method stub
		return fdao.findAll() ;
	}

	@Override
	public Feedback getFeedbackById(int fId) {
		Optional<Feedback> op=fdao.findById(fId);
		if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
		
	}

	@Override
	public void addnewfeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		fdao.save(feedback);
		
	}

	@Override
	public void deleteFeedbackById(int fId) {
		// TODO Auto-generated method stub
				fdao.deleteById(fId);
		
	}

	@Override
	public void updateFeedbackById(Feedback feedback) {
		Optional<Feedback> feed=fdao.findById(feedback.getfId());
		if(feed.isPresent()) {
			Feedback a=feed.get();
			a.setFirstName(feedback.getFirstName());
			a.setLastName(feedback.getLastName());
			a.setEmailId(feedback.getEmailId());
			a.setSubject(feedback.getSubject());
			a.setYourMessage(feedback.getYourMessage());
			fdao.save(a);
		}
		
	}
	

}
