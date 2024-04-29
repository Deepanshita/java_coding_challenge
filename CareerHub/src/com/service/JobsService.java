package com.service;

import com.dao.JobsDaoImpl;
import com.model.Applicants;
import com.model.Jobs;

import java.sql.SQLException;
import java.util.List;

import com.dao.JobsDao;
public class JobsService {
	JobsDao dao= new JobsDaoImpl();
	public List<Jobs> getJobListings() throws SQLException{
		return dao.getJobListings();
	}
	public List<Applicants> getApplicantsByjobId(int jobID) throws SQLException{
		return dao.getApplicantsByjobId(jobID);
	}
}
