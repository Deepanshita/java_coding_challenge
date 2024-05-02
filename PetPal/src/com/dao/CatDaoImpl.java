package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.CatDao;
import com.model.Cat;
import com.utility.DBConnection;

public class CatDaoImpl implements CatDao {

	@Override
	public int addCat(Cat cat) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into cat (color, pet_id) values (?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cat.getCatColor());
		pstmt.setInt(2, cat.getPetId());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

}