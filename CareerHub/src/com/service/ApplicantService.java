package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.ApplicantsDao;
import com.dao.ApplicantsDaoimpl;
import com.model.Applicants;

public class ApplicantService {
      ApplicantsDao dao= new ApplicantsDaoimpl() ;
      public int applyForJob(int applicantID, int jobID, String coverLetter) throws SQLException{
    	  return dao.applyForJob(applicantID, jobID, coverLetter);
      }
      public boolean createProfile(String firstName, String lastName, String email, String phone, String resume)
  			throws SQLException{
    	  return dao.createProfile(firstName, lastName, email, phone, resume);
      }
      public List<Applicants> getApplicants() throws SQLException{
    	  return dao.getApplicants();
      }
      
}
