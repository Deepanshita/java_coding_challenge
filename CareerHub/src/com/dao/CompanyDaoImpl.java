package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Company;
import com.model.Jobs;
import com.utility.DBConnection;

public class CompanyDaoImpl implements CompanyDao{

	@Override
	public boolean postJob(String jobTitle, String jobDescription, String jobLocation, double salary,
			String jobType,String postedDate, int companyID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="insert into jobs(title, description, location, salary, JobType, posted_date, company_id) values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, jobTitle);
        pstmt.setString(2, jobDescription);
        pstmt.setString(3, jobLocation);
        pstmt.setDouble(4, salary);
        pstmt.setString(5, jobType);
        pstmt.setString(6, postedDate);
        pstmt.setInt(7, companyID);
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected>0;
		
	}

	@Override
	public List<Jobs> getJobs(int companyID) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql="SELECT * FROM jobs where company_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, companyID);
		ResultSet rst = pstmt.executeQuery();
		List<Jobs> list = new ArrayList<>();
		while(rst.next() == true) {
			int id=rst.getInt("id");
			String title=rst.getString("title");
			String description=rst.getString("description");
			String location=rst.getString("location");
			double salary=rst.getDouble("salary");
			String jobType=rst.getString("JobType");
			String postedDate =rst.getString("posted_date");
			int companyid = rst.getInt("company_id");
		        Jobs job = new Jobs(id, title, description, location, salary, jobType, postedDate, companyid);
		        list.add(job);
		}
		DBConnection.dbClose();		
		return list;
	}

	@Override
	public void insertCompany(Company company) throws SQLException {
		// TODO Auto-generated method stub
		 Connection con = DBConnection.dbConnect();
		 String sql = "INSERT INTO Company (name, location) VALUES (?, ?)";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, company.getCompanyName());
         pstmt.setString(2, company.getLocation());
         pstmt.executeUpdate();
 		 DBConnection.dbClose();		

	}

	@Override
	public List<Company> getCompanies() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
		String sql = "SELECT * FROM Company";
        List<Company> companies = new ArrayList<>();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		 while (rs.next()) {
             Company company = new Company();
             company.setCompanyID(rs.getInt("id"));
             company.setCompanyName(rs.getString("name"));
             company.setLocation(rs.getString("location"));
             
             companies.add(company);
         }
			DBConnection.dbClose();		

     return companies;
 }
	}

