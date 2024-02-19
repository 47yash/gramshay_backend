package com.demo.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tbl_complaints")
public class Complaint {
	
	@Id
	@Column(name="complaint_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	
	@Column(name = "posted_at")
    private LocalDateTime postedAt = LocalDateTime.now();

	@Column(name="category")
	private String category;
	
	@Column(name="complaint_description")
	@NonNull
	private String description;
	
	@Column(name="forGS")
	private int forGS;

	@Column(name="forAdmin")
	private int forAdmin;
	
	@Column(name="status")
	private String status;
	
	@Column(name="state")
	private String state;
	
	@Column(name="district")
	private String district;
	
	@Column(name="taluka")
	private String taluka;
	
	@Column(name="village")
	private String village;
	
	@Column(name="remarks")
	private String remarks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id") // Assuming the column name in tbl_complaints referencing user_id
	@JsonIgnore
	private User user;
	

	public Complaint() {
		super();
	}


	public Complaint(int complaintId, User user, LocalDateTime postedAt, String category, String description,
			int forGS, int forAdmin, String status, String state, String district, String taluka, String village,
			String remarks) {
		super();
		this.complaintId = complaintId;
		
		this.postedAt = LocalDateTime.now();
		this.category = category;
		this.description = description;
		this.forGS = forGS;
		this.forAdmin = forAdmin;
		this.status = status;
		this.state = state;
		this.district = district;
		this.taluka = taluka;
		this.village = village;
		this.remarks = remarks;
	}


	public int getComplaintId() {
		return complaintId;
	}


	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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


	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId +  ", postedAt=" + postedAt + ", category="
				+ category + ", description=" + description + ", forGS=" + forGS + ", forAdmin=" + forAdmin
				+ ", status=" + status + ", state=" + state + ", district=" + district + ", taluka=" + taluka
				+ ", village=" + village + ", remarks=" + remarks + "]";
	}


}
