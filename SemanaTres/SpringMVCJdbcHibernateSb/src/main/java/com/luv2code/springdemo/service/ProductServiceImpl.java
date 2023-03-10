package com.luv2code.springdemo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.ProductDAO;
import com.luv2code.springdemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	// need to inject customer dao
	@Autowired
	//Indicamos qué inyectar -- Inyectamos con JDBC
	@Qualifier("productDAOJdbc")
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts(){
			return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		//System.out.println("PRECIO ServiceImpl: " + theProduct.getCosto());
		//theCustomer.setPrecio(theCustomer.getCosto()+5);
		
		switch(theProduct.getCategoria()) {
		case 1:
			theProduct.setPrecio(theProduct.getCosto()+5);
			break;
		case 2:
			theProduct.setPrecio(theProduct.getCosto()+10);
			break;
		case 3:
			theProduct.setPrecio(theProduct.getCosto()+20);
			break;
		case 4:
			theProduct.setPrecio(theProduct.getCosto()+30);
			break;
		}
		//ystem.out.println("PRECIO ServiceImpl: " + theProduct.getPrecio());
			
		productDAO.saveProduct(theProduct);
	}

	@Override
	@Transactional
	public Product getProduct(int theId) {
		
		return productDAO.getProduct(theId);
	}

	@Override
	@Transactional
	public void deleteProduct(int theId) {
		
		productDAO.deleteProduct(theId);
	}
}





