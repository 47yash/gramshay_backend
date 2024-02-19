package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_Feedback")
public class Feedback {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="f_Id")
	private int fId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="message")
	private String yourMessage;

	public Feedback() {
		super();
	}

	public Feedback(int fId, String firstName, String lastName, String emailId, String subject, String yourMessage) {
		super();
		this.fId = fId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.subject = subject;
		this.yourMessage = yourMessage;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getYourMessage() {
		return yourMessage;
	}

	public void setYourMessage(String yourMessage) {
		this.yourMessage = yourMessage;
	}

	@Override
	public String toString() {
		return "Feedback [fId=" + fId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", Subject=" + subject + ", yourMessage=" + yourMessage + "]";
	}
	
	
	

}
