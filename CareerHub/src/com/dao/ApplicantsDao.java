package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Applicants;

public interface ApplicantsDao {
	int applyForJob(int applicantID, int jobID, String coverLetter) throws SQLException;
	boolean createProfile(String firstName, String lastName, String email, String phone, String resume) throws SQLException;
	void insertApplicant(Applicants applicant) throws SQLException;
	List<Applicants> getApplicants() throws SQLException;
}
