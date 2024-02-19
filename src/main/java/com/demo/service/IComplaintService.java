package com.demo.service;

import java.util.List;

import com.demo.model.Complaint;

public interface IComplaintService {

	List<?> getAllComplaints();

	Complaint getComplaintById(int id);

	void addNewComplaint(Complaint comp, int id);

	void updateComplaint(Complaint comp);

	void deleteComplaint(int id);

	List<?> getNewComplaints();

	List<?> getInProcessComplaints();

	List<?> getCompletedComplaints();

	void editNewStatus(Complaint cmp);

	void editInProcessStatus(Complaint cmp);

	List<?> getVillageComplaints(String village);

	int getCompletedCount();

	int getInProcessCount();

	int getNewCount();

	Object getLatest();

}
