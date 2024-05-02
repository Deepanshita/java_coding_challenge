package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dao.PetDao;
import com.model.Pet;
import com.utility.DBConnection;

public class PetDaoImpl implements PetDao {

	@Override
	public int addPet(Pet pet) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "insert into pet (name, age, type, isAvailable) values (?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, pet.getName());
		pstmt.setInt(2, pet.getAge());
		pstmt.setString(3, pet.getType());
		pstmt.setInt(4, pet.getIsAvailable());
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Pet> getAllPets() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from pet";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Pet> list = new ArrayList<>();
		while (rs.next()) {
			int petId = rs.getInt("id");
			String petName = rs.getString("name");
			int petAge = rs.getInt("age");
			String petType = rs.getString("type");
			int isAvavilable = rs.getInt("isAvailable");
			Pet pet = new Pet(petId, petName, petAge, petType, isAvavilable);
			list.add(pet);
		}
		DBConnection.dbClose();
		return list;
	}

	@Override
	public int removePetById(int petId) throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "update pet set isActive='no' where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, petId);
		int status = pstmt.executeUpdate();
		DBConnection.dbClose();
		return status;
	}

	@Override
	public List<Pet> getAllAvailablePets() throws SQLException {
		Connection con = DBConnection.dbConnect();
		String sql = "select * from pet where isAvailable=1 and isActive='Yes'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Pet> list = new ArrayList<>();
		while (rs.next()) {
			int petId = rs.getInt("id");
			String petName = rs.getString("name");
			int petAge = rs.getInt("age");
			String petType = rs.getString("type");
			int isAvavilable = rs.getInt("isAvailable");
			Pet pet = new Pet(petId, petName, petAge, petType, isAvavilable);
			list.add(pet);
		}
		DBConnection.dbClose();
		return list;
	}

}