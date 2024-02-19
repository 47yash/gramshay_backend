package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.IAdminDao;
import com.demo.dto.Admindto;
import com.demo.model.Admin;

@Service 
@Transactional
public class AdminService implements IAdminService {

	@Autowired
	private IAdminDao adao;
	
	@Override
	public List<Admindto> getAdmins() {
		List<Admin> alist = adao.findAll();
		List<Admindto> adlist = new ArrayList<Admindto>();
		for(Admin a:alist) {
			Admindto ad = new Admindto();
			ad.setAdminId(a.getAdminId());
			ad.setEmailId(a.getEmailId());
			ad.setFirstName(a.getFirstName());
			ad.setLastName(a.getLastName());
			ad.setUsername(a.getUsername());
			ad.setPhoneNumber(a.getPhoneNumber());
			adlist.add(ad);
		}
		return adlist;
	}

	@Override
	public void addnewAdmin(Admin adm) {
		adao.save(adm);
	}

	@Override
	public Admin getAdminById(int adminID) {
		Optional<Admin> op=adao.findById(adminID);
		if(op.isPresent()) {
			 return op.get();
		 }
		 return null;	
	}

	@Override
	public void updateById(Admin adm) {
		Optional<Admin> admin=adao.findById(adm.getAdminId());
		if(admin.isPresent()) {
			Admin a=admin.get();
			a.setFirstName(adm.getFirstName());
			a.setLastName(adm.getLastName());
			a.setUsername(adm.getUsername());
			a.setPhoneNumber(adm.getPhoneNumber());
			a.setEmailId(adm.getEmailId());
			adao.save(a);
		}		
	}

	@Override
	public void deleteById(int adminId) {
		adao.deleteById(adminId);
	}

	@Override
	public boolean validateAdminCredentials(String username, String password) {
		Admin user = adao.findByUsername(username);
	    return user != null && user.getPassword().equals(password);
	}

	@Override
	public Admindto getAdminByUsername(String username) {
		Admin ad = adao.findByUsername(username);
		Admindto admin = new Admindto();
		admin.setAdminId(ad.getAdminId());
		admin.setUsername(ad.getUsername());
		admin.setFirstName(ad.getFirstName());
		admin.setLastName(ad.getLastName());
		admin.setPhoneNumber(ad.getPhoneNumber());
		admin.setEmailId(ad.getEmailId());
		return admin;
	}

}