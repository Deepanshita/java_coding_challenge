package com.test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Test;

import com.model.Orders;
import com.service.OrdersService;

public class OrdersServiceTest {
     OrdersService os= new OrdersService();
     @Test
     public void testGetOrderDetails() throws SQLException {
         int orderId = 1;
         Orders expectedOrderDetails = new Orders( 1, 1, "2024-04-25 10:00:00", 199.99 );

         Orders actualOrderDetails = os.getOrderDetails(orderId);

         assertEquals(expectedOrderDetails, actualOrderDetails);
     }
     
}
