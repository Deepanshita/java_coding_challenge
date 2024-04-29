package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Applicants;
import com.model.Jobs;
import com.utility.DBConnection;

public class JobsDaoImpl implements JobsDao{

	@Override
	public boolean apply(int jobID, int applicantID, String coverLetter) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="insert into applicantions(applicants_id, jobs_id, application_date, cover_letter) values (?,?,now(),?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, jobID);
         pstmt.setInt(2, applicantID);
         pstmt.setString(3, coverLetter);
         int rowsAffected = pstmt.executeUpdate();
 	    DBConnection.dbClose();		
		 return rowsAffected>0;
	}

	@Override
	public List<Applicants> getApplicantsByjobId(int jobID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT a.* FROM applicants a INNER JOIN applications app ON a.id = app.applicants_id WHERE app.jobs_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, jobID);
		ResultSet rst = pstmt.executeQuery();
		List<Applicants> list = new ArrayList<>();
		 while (rst.next()) {
             int applicantID = rst.getInt("id");
             String firstName = rst.getString("first_name");
             String lastName = rst.getString("last_name");
             String email = rst.getString("email");
             String phone = rst.getString("phone");
             String resume = rst.getString("resume");
             Applicants applicant = new Applicants(applicantID, firstName, lastName, email, phone, resume);
             list.add(applicant);
         }
	    DBConnection.dbClose();		
		return list;
	}

	@Override
	public void insertJobListing(Jobs job) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql="insert into jobs(title, description, location, salary, JobType, posted_date, company_id) values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, job.getTitle());
        pstmt.setString(2, job.getDescription());
        pstmt.setString(3, job.getLocation());
        pstmt.setDouble(4, job.getSalary());
        pstmt.setString(5, job.getJobType());
        pstmt.setString(6, job.getPostedDate());
        pstmt.setInt(7, job.getCompanyID());
        pstmt.executeUpdate();
	    DBConnection.dbClose();
	    
		
	}

	@Override
	public List<Jobs> getJobListings() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM jobs";
	    List<Jobs> jobListings = new ArrayList<>();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		 while (rs.next()) {
             Jobs job = new Jobs();
             job.setJobID(rs.getInt("id"));
             job.setTitle(rs.getString("title"));
             job.setDescription(rs.getString("description"));
             job.setLocation(rs.getString("location"));
             job.setSalary(rs.getDouble("salary"));
             job.setJobType(rs.getString("jobType"));
             job.setPostedDate(rs.getString("posted_date"));
             job.setCompanyID(rs.getInt("company_id"));
             
             jobListings.add(job);
	    		
	}
		 DBConnection.dbClose();
		return jobListings;

	}
}
