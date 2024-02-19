package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Gramsevak;


@Repository
public interface IGramsevakDao extends JpaRepository<Gramsevak,Integer> {
	
	@Query("SELECT u FROM Gramsevak u WHERE u.username = :username")
	Gramsevak findByUsername(String username);

}
