package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.dao.ItemDonationDao;
import com.model.ItemDonation;
import com.utility.DBConnection;

public class ItemDonationDaoImpl implements ItemDonationDao {

	@Override
	public int recordDonation(ItemDonation donation, int donationId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into item_donation ( type,date,donation_id) values(?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, donation.getItemType());
		pstmt.setString(2, donation.getDonationDate());
		pstmt.setInt(3, donationId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}
