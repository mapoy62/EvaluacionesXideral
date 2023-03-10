package com.luv2code.springdemo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	//Indicamos qué inyectar -- Inyectamos con JDBC
	@Qualifier("customerDAOJdbc")
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers(){
			return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		System.out.println("PRECIO ServiceImpl: " + theCustomer.getCosto());
		//theCustomer.setPrecio(theCustomer.getCosto()+5);
		
		switch(theCustomer.getCategoria()) {
		case 1:
			theCustomer.setPrecio(theCustomer.getCosto()+5);
			break;
		case 2:
			theCustomer.setPrecio(theCustomer.getCosto()+10);
			break;
		case 3:
			theCustomer.setPrecio(theCustomer.getCosto()+20);
			break;
		case 4:
			theCustomer.setPrecio(theCustomer.getCosto()+30);
			break;
		}
		System.out.println("PRECIO ServiceImpl: " + theCustomer.getPrecio());
			
		customerDAO.saveCustomer(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		
		customerDAO.deleteCustomer(theId);
	}
}





