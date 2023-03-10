package com.xideral.productmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xideral.productmvc.dao.ProductDAO;
import com.xideral.productmvc.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	// need to inject customer dao
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	@Transactional
	public List<Product> getProducts() {
		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public void saveProduct(Product theProduct) {
		//System.out.println("PRECIO ServiceImpl: " + theProduct.getCosto());
		
		//Segpun la catergoría, será el precio final
		switch(theProduct.getCategoria()) {
		case 1:
			theProduct.setPrecio(theProduct.getCosto()+6);
			break;
		case 2:
			theProduct.setPrecio(theProduct.getCosto()+7);
			break;
		case 3:
			theProduct.setPrecio(theProduct.getCosto()+8);
			break;
		case 4:
			theProduct.setPrecio(theProduct.getCosto()+3);
			break;
		}
		//System.out.println("PRECIO ServiceImpl: " + theProduct.getPrecio());
			
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





