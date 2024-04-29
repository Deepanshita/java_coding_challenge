package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Company;
import com.model.Jobs;

public interface CompanyDao {
	boolean postJob( String jobTitle, String jobDescription, String jobLocation, double salary, String jobType,String postedDate ,int companyID) throws SQLException;
	List<Jobs> getJobs(int companyID) throws SQLException;
	void insertCompany(Company company) throws SQLException;
	List<Company> getCompanies() throws SQLException;
}
