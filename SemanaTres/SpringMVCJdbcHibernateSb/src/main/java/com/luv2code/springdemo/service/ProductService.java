package com.luv2code.springdemo.service;

import java.sql.SQLException;
import java.util.List;

import com.luv2code.springdemo.entity.Product;

public interface ProductService {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
}
