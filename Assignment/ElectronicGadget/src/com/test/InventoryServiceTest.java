package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.model.Inventory;
import com.service.InventoryService;

public class InventoryServiceTest {
	 InventoryService inventoryService=new InventoryService();
	 @Test
	    public void testAddToInventory() throws SQLException {
	        int inventoryID = 1;
	        int quantityToAdd = 10;
	        int result=1;
	        int actualResult = inventoryService.addToInventory(inventoryID, quantityToAdd);
	        assertEquals(result, actualResult);
	    }
	 @Test
	    public void testListOutOfStockProducts() throws SQLException {
	        List<Inventory> outOfStockProducts = inventoryService.listOutOfStockProducts();
	        assertTrue(outOfStockProducts.isEmpty());
	    }
	 @Test
	    public void testListLowStockProducts() throws SQLException {
	        int threshold = 60;

	        List<Inventory> lowStockProducts = inventoryService.listLowStockProducts(threshold);

	        assertEquals(3, lowStockProducts.size()); 
	    }
}
