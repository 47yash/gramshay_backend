package com.demo.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

public class Complaintdto {
	
	private int complaintId;
	
	private LocalDateTime postedAt;

	private String category;
	
	private String description;
	
	private int forGS;
	
	private int forAdmin;
	
	private String status;
	
	private String state;
	
	private String district;
	
	private String taluka;
	
	private String village;
	
	private String remarks;
	
	private int userId;


	public Complaintdto() {
		super();
	}


	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}


	public LocalDateTime getPostedAt() {
		return postedAt;
	}


	public void setPostedAt(LocalDateTime postedAt) {
		this.postedAt = postedAt;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getForGS() {
		return forGS;
	}


	public void setForGS(int forGS) {
		this.forGS = forGS;
	}


	public int getForAdmin() {
		return forAdmin;
	}


	public void setForAdmin(int forAdmin) {
		this.forAdmin = forAdmin;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getDistrict() {
		return district;
	}


	public void setDistrict(String district) {
		this.district = district;
	}


	public String getTaluka() {
		return taluka;
	}


	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Complaintdto [complaintId=" + complaintId + ", postedAt=" + postedAt + ", category=" + category
				+ ", description=" + description + ", forGS=" + forGS + ", forAdmin=" + forAdmin + ", status=" + status
				+ ", state=" + state + ", district=" + district + ", taluka=" + taluka + ", village=" + village
				+ ", remarks=" + remarks + ", userId=" + userId + "]";
	}

}
