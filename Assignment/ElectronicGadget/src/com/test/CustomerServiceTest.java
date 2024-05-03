package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.model.Customer;
import com.service.CustomerService;

public class CustomerServiceTest {
   CustomerService cs=new CustomerService();
   @Test
	public void Testadd() throws SQLException {
	   Customer customer = new Customer(7,"esha", "gupta","esha@gmail.com","675858","ydgydg");
       int result = cs.add(customer);
       assertEquals(1, result);
   }
   @Test
   public void testGetAllCustomers() throws SQLException {
       List<Customer> customers = cs.getAllCustomers();

       assertEquals(false, customers.isEmpty());
   }
   @Test
   public void testGetCustomerDetails() throws SQLException {
       int customerId = 1; // Assuming this customer exists in the database

       Customer customer = cs.getCustomerDetails(customerId);
       assertEquals(false, customer == null);
   }
   @Test
   public void testUpdateCustomerInfo() throws SQLException {
       int customerId = 1; 
       String newEmail = "newemail@example.com";
       String newPhone = "987654321";
       String newAddress = "New Address";

       // Execution: Update customer information
       cs.updateCustomerInfo(customerId, newEmail, newPhone, newAddress);

       // Verification: Get updated customer details and verify if they match the new information
       Customer updatedCustomer = cs.getCustomerDetails(customerId);
       assertEquals(newEmail, updatedCustomer.getEmail());
       assertEquals(newPhone, updatedCustomer.getPhone());
       assertEquals(newAddress, updatedCustomer.getAddress());
   }
}
