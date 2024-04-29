package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Applications;
import com.utility.DBConnection;

public class ApplicationsDaoImpl implements ApplicationsDao{

	@Override
	public void insertJobApplication(Applications application) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "INSERT INTO applications (applicants_id, jobs_id, application_date, cover_letter) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, application.getApplicationsID());
        pstmt.setInt(2, application.getJobsID());
        pstmt.setString(3, application.getApplicationDate());
        pstmt.setString(4, application.getCoverLetter());
        DBConnection.dbClose();
        pstmt.executeUpdate();
		
	}

	@Override
	public List<Applications> getApplicationsForJob(int jobID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		 String sql = "SELECT * FROM applications WHERE jobs_id = ?";
	     List<Applications> applications = new ArrayList<>();
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setInt(1, jobID);
		 ResultSet rs = pstmt.executeQuery();		 
		 while (rs.next()) {
             Applications application = new Applications();
             application.setApplicationsID(rs.getInt("id"));
             application.setApplicantsID(rs.getInt("applicants_id"));
             application.setJobsID(rs.getInt("jobs_id"));
             application.setApplicationDate(rs.getString("application_date"));
             application.setCoverLetter(rs.getString("cover_letter"));
             
             applications.add(application);
	}
		 return applications; 

}
}
