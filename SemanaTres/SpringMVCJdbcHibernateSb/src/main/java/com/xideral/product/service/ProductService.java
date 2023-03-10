package com.xideral.product.service;

import java.sql.SQLException;
import java.util.List;

import com.xideral.product.entity.Product;

public interface ProductService {

	public List<Product> getProducts();

	public void saveProduct(Product theProduct);

	public Product getProduct(int theId);

	public void deleteProduct(int theId);
	
}
