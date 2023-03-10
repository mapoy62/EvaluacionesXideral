package com.xideral.productmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xideral.productmvc.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Product> getProducts() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by nameProduct
		Query<Product> theQuery = 
				currentSession.createQuery("from Product order by nomProd",
											Product.class);
		
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
				
		// return the results		
		return products;
	}

	@Override
	public void saveProduct(Product theProduct) {

		// get current hibernate session 
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Product getProduct(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

	@Override
	public void deleteProduct(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();		
	}

}











