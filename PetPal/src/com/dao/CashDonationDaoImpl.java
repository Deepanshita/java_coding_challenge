package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.dao.CashDonationDao;
import com.model.CashDonation;
import com.utility.DBConnection;

public class CashDonationDaoImpl implements CashDonationDao {

	@Override
	public int recordDonation(CashDonation donation, int donationId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into cash_donation ( donation_date, donation_amount, donation_id) values"
				+ "(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, donation.getDonationDate());
		pstmt.setDouble(2, donation.getDonationAmount());
		pstmt.setInt(3, donationId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}