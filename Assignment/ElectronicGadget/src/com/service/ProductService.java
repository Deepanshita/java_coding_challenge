package com.service;

import java.sql.SQLException;

import com.dao.ProductDao;
import com.dao.ProductDaoImpl;
import com.exception.ProductNotFoundException;
import com.model.Product;

public class ProductService {
      ProductDao dao=new ProductDaoImpl();
      public int addProduct(Product product) throws SQLException {
			return dao.addProduct(product);
		}
  	public void deleteProduct(int productID) throws SQLException {
  		dao.deleteProduct(productID);
  	}
	public Product getProductDetails(int productID) throws SQLException,ProductNotFoundException {
		return dao.getProductDetails(productID);
	}
	public void updateProductInfo(int productID, String productName, String description, double price)throws SQLException {
	    dao.updateProductInfo(productID, productName, description, price);
	}
	public boolean isProductInStock(int productID) throws SQLException {
		return dao.isProductInStock(productID);
	}
}
