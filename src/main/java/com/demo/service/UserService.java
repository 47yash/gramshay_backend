package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IComplaintDao;
import com.demo.dao.IUserDao;
import com.demo.model.Complaint;
import com.demo.model.User;
import com.demo.dto.Complaintdto;
import com.demo.dto.Userdto;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao udao;
	@Autowired
	private IComplaintService complaintService;

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return udao.findAll();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		User op = udao.findById(userId).orElse(null);
		op.getLsComp();
		if (op != null) {
			return op;
		}
		return null;
	}

	@Override
	public void addnewUser(User user) {
		udao.save(user);

	}

	@Override
	public void updateUserById(User adm) {
		// TODO Auto-generated method stub
		Optional<User> user = udao.findById(adm.getUserId());
		if (user.isPresent()) {
			User a = user.get();
			a.setFirstName(adm.getFirstName());
			a.setLastName(adm.getLastName());
			a.setUsername(adm.getUsername());
			a.setPhoneNumber(adm.getPhoneNumber());
			a.setEmailId(adm.getEmailId());
			udao.save(a);
		}

	}

	@Override
	public void RemoveById(int userId) {
		udao.deleteById(userId);
	}

	@Override
	public boolean validateUserCredentials(String username, String password) {
		User user = udao.findByUsername(username);
		return user != null && user.getPassword().equals(password);
	}

	@Override
	public Userdto getUserByUsername(String username) {
		User us = udao.findByUsername(username);
//		us.setLsComp((List<Complaint>) complaintService.getComplaintById(us.getUserId()));
		Userdto user = new Userdto();
		user.setUserId(us.getUserId());
		user.setUsername(us.getUsername());
		user.setFirstName(us.getFirstName());
		user.setLastName(us.getLastName());
		user.setDob(us.getDob());
		user.setEmailId(us.getEmailId());
		user.setPhoneNumber(us.getPhoneNumber());
		user.setState(us.getState());
		user.setCity(us.getCity());
		user.setDistrict(us.getDistrict());
		user.setTaluka(us.getTaluka());
		user.setVillage(us.getVillage());
		user.setAddress(us.getAddress());
		user.setPanchayat(us.getPanchayat());
		user.setPostoffice(us.getPostoffice());
		user.setPincode(us.getPincode());
		user.setLsComp(us.getLsComp());
		return user;
	}

}
