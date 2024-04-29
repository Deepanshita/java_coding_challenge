package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Applicants;
import com.utility.DBConnection;

public class ApplicantsDaoimpl implements ApplicantsDao{

	@Override
	public int applyForJob(int applicantID, int jobID, String coverLetter) throws SQLException {
		Connection con = DBConnection.dbConnect();

		 String sql="insert into applications(applicants_id, jobs_id, application_date, cover_letter) values (?,?,now(),?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, jobID);
         pstmt.setInt(2, applicantID);
         pstmt.setString(3, coverLetter);
         int status =pstmt.executeUpdate();
 	     DBConnection.dbClose();		

         return status;
		
	}

	@Override
	public boolean createProfile(String firstName, String lastName, String email, String phone, String resume)
			throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="INSERT INTO applicants (first_name, last_name, email, phone, resume) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, firstName);
        pstmt.setString(2, lastName);
        pstmt.setString(3, email);
        pstmt.setString(4, phone);
        pstmt.setString(5, resume);
		
		int status= pstmt.executeUpdate();
		DBConnection.dbClose();
		return status>0;
	}

	@Override
	public void insertApplicant(Applicants applicant) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		 String sql = "INSERT INTO applicants (first_name, last_name, email, phone, resume) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, applicant.getFirstName());
         pstmt.setString(2, applicant.getLastName());
         pstmt.setString(3, applicant.getEmail());
         pstmt.setString(4, applicant.getPhone());
         pstmt.setString(5, applicant.getResume());
 		 DBConnection.dbClose();

         pstmt.executeUpdate();

		
	}

	@Override
	public List<Applicants> getApplicants() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM applicants";
        List<Applicants> applicants = new ArrayList<>();
		PreparedStatement pstmt = con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Applicants applicant = new Applicants();
            applicant.setApplicantID(rs.getInt("id"));
            applicant.setFirstName(rs.getString("first_name"));
            applicant.setLastName(rs.getString("last_name"));
            applicant.setEmail(rs.getString("email"));
            applicant.setPhone(rs.getString("phone"));
            applicant.setResume(rs.getString("resume"));
            
            applicants.add(applicant);
        }

    DBConnection.dbClose();
    return applicants;
}
}
