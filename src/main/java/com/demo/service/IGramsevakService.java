package com.demo.service;

import java.util.List;

import com.demo.model.Gramsevak;
import com.demo.dto.Gramsevakdto;

public interface IGramsevakService {

	List<Gramsevak> getAllGs();

	Gramsevak getGsById(int gsId);

	void addnewGs(Gramsevak gramsevak);

	void updateGsById(Gramsevak gramsevak);

	void deleteGsById(int gsId);

	boolean validateGramsevakCredentials(String username, String password);

	Gramsevakdto getGsByUsername(String username);

}
