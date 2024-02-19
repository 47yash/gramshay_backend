package com.demo.service;

import java.util.List;

import com.demo.dto.Admindto;
import com.demo.model.Admin;

public interface IAdminService {
	List<Admindto> getAdmins();

	void addnewAdmin(Admin adm);

	Admin getAdminById(int adminID);

	void updateById(Admin adm);

	void deleteById(int adminId);

	boolean validateAdminCredentials(String username, String password);

	Admindto getAdminByUsername(String username);
}
