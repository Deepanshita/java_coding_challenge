package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.dao.DonationDao;
import com.model.Donation;
import com.utility.DBConnection;

public class DonationDaoImpl implements DonationDao {

	@Override
	public int recordDonation(Donation donation) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into donation (donor_name,pet_id) values" + "(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, donation.getDonorName());
		pstmt.setInt(2, donation.getPetId());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}