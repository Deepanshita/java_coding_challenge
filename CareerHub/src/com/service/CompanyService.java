package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CompanyDao;
import com.dao.CompanyDaoImpl;
import com.model.Company;
import com.model.Jobs;

public class CompanyService {
       CompanyDao dao = new CompanyDaoImpl();
       public void insertCompany(Company company) throws SQLException{
    	    dao.insertCompany(company);
       }
       public List<Company> getCompanies() throws SQLException{
    	   return dao.getCompanies();
       }
       public List<Jobs> getJobs(int companyID) throws SQLException{
    	   return dao.getJobs(companyID);
       }
       public boolean postJob(String jobTitle, String jobDescription, String jobLocation, double salary,
   			String jobType,String postedDate, int companyID) throws SQLException {
    	   return dao.postJob(jobTitle, jobDescription, jobLocation, salary, jobType, postedDate, companyID);
       }
   }
