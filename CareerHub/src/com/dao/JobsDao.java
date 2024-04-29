package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Applicants;
import com.model.Jobs;

public interface JobsDao {
	boolean apply(int jobID, int applicantID, String coverLetter) throws SQLException;
    List<Applicants> getApplicantsByjobId(int jobID) throws SQLException;
    void insertJobListing(Jobs job) throws SQLException;
    List<Jobs> getJobListings() throws SQLException;
}
