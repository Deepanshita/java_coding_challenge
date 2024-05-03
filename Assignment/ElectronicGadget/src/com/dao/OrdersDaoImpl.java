package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Customer;
import com.model.Orders;
import com.utility.DBConnection;

public class OrdersDaoImpl implements OrdersDao{

	@Override
	public double calculateTotalAmount(int orderID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
        String sql="SELECT total_amount FROM Orders WHERE id=?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,orderID);
        ResultSet rst = pstmt.executeQuery();
		if(rst.next()) {
			return rst.getDouble("total_amount");
		}
		DBConnection.dbClose();	
		return 0.0;
	}

	@Override
	public Orders getOrderDetails(int orderID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
        String sql="SELECT * FROM Orders WHERE id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,orderID);
        ResultSet rst  = pstmt.executeQuery();
	    Orders o1=new Orders();
		if(rst.next()) {
			o1.setOrderID(rst.getInt("id"));
			o1.setOrderDate(rst.getString("order_date"));
			o1.setTotalAmount(rst.getDouble("total_amount"));
			o1.setCustomerID(rst.getInt("Customer_id"));
		}
		DBConnection.dbClose();
		return o1;
	}

	/*@Override
	public void updateOrderStatus(int orderID, String status) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
        String sql="Update orders SET status=? where id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1, orderID);
		
	}*/

	@Override
	public void cancelOrder(int orderID) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBConnection.dbConnect();
        String sql="DELETE FROM Orders WHERE id=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,orderID);
        pstmt.executeUpdate();
		
	}

}
