package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Product;

@Repository
public class ProductDAOHibernate implements ProductDAO {

	//Inyecta Entity Manager
	private EntityManager entityManager;
	
	//Establece inyección de contructor
	@Autowired
	public ProductDAOHibernate(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
			
	@Override
	public List<Product> getProducts() {
		System.out.println("PASO POR DAOHibernet");
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query  ... sort by id
		Query<Product> theQuery = 
				currentSession.createQuery("from Product order by id",
											Product.class);
		
		// execute query and get result list
		List<Product> products = theQuery.getResultList();
				
		// return the results		
		return products;
	}

	@Override
	public void saveProduct(Product theProduct) {

		// get current hibernate session 
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theProduct);
		
	}

	@Override
	public Product getProduct(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// now retrieve/read from database using the primary key
		Product theProduct = currentSession.get(Product.class, theId);
		
		return theProduct;
	}

	@Override
	public void deleteProduct(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Product where id=:productId");
		theQuery.setParameter("productId", theId);
		
		theQuery.executeUpdate();		
	}

}











