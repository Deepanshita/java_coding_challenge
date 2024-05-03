package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.model.Customer;
public class CustomerService {
	CustomerDao dao = new CustomerDaoImpl();
	public int add(Customer customer) throws SQLException {
		return dao.addCustomer(customer);
	}
	
	public List<Customer> getAllCustomers() throws SQLException{
		return dao.getAllCustomers();
	}
	
	public int calculateTotalOrders(int customerID) throws SQLException{
		return dao.calculateTotalOrders(customerID);
	}

   public Customer getCustomerDetails(int customerID) throws SQLException{
	   return dao.getCustomerDetails(customerID);
   }
  
  public void updateCustomerInfo(int customerID, String email, String phone, String address) throws SQLException{
	   dao.updateCustomerInfo(customerID, email, phone, address);
   }

}
