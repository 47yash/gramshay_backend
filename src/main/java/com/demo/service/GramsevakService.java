package com.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IGramsevakDao;
import com.demo.dto.Gramsevakdto;
import com.demo.model.Gramsevak;



@Service
public class GramsevakService implements IGramsevakService {
	
	@Autowired
	private IGramsevakDao gdao;

	@Override
	public List<Gramsevak> getAllGs() {
		return gdao.findAll();
	}

	@Override
	public Gramsevak getGsById(int gsId) {
		Optional<Gramsevak> op=gdao.findById(gsId);
		if(op.isPresent()) {
			 return op.get();
		 }
		 return null;
		
	}

	@Override
	public void addnewGs(Gramsevak gramsevak) {
		gdao.save(gramsevak);
		
	}

	@Override
	public void updateGsById(Gramsevak gramsevak) {
		Optional<Gramsevak> Gs=gdao.findById(gramsevak.getGsid());
		if(Gs.isPresent()) {
			Gramsevak gramsev =Gs.get();
			gramsev.setFirstName(gramsevak.getFirstName());
			gramsev.setLastName(gramsevak.getLastName());
			gramsev.setUsername(gramsevak.getUsername());
			gramsev.setPhoneNumber(gramsevak.getPhoneNumber());
			gramsev.setEmailId(gramsevak.getEmailId());
			
			gdao.save(gramsev);
		}
	}

	@Override
	public void deleteGsById(int gsId) {
		gdao.deleteById(gsId);
	}

	@Override
	public boolean validateGramsevakCredentials(String username, String password) {
		Gramsevak user = gdao.findByUsername(username);
	    return user != null && user.getPassword().equals(password);
	}

	@Override
	public Gramsevakdto getGsByUsername(String username) {
		Gramsevak gs = gdao.findByUsername(username);
		Gramsevakdto gsdto = new Gramsevakdto();
		gsdto.setGsId(gs.getGsId());
		gsdto.setFirstName(gs.getFirstName());
		gsdto.setLastName(gs.getLastName());
		gsdto.setEmailId(gs.getEmailId());
		gsdto.setPhoneNumber(gs.getPhoneNumber());
		gsdto.setUsername(gs.getUsername());
		gsdto.setState(gs.getState());
		gsdto.setDistrict(gs.getDistrict());
		gsdto.setTaluka(gs.getTaluka());
		gsdto.setVillage(gs.getVillage());
		gsdto.setStatus(gs.getStatus());
		return gsdto;
		
	}



}
