package com.dao;

import java.sql.SQLException;

public interface OrderDetailsDao {
	double calculateSubtotal(int orderDetailID) throws SQLException;
    String getOrderDetailInfo(int orderDetailID) throws SQLException;
    void updateQuantity(int orderDetailID, int quantity) throws SQLException;
    void addDiscount(int orderDetailID, Double discount) throws SQLException;
    public void deleteOrderDetailsByOrderId(int orderID) throws SQLException;
}
