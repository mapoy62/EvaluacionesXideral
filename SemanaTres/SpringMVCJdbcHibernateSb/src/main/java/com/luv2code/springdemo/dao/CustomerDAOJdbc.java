package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
//import com.luv2code.web.jdbc.Student;

@Repository
public class CustomerDAOJdbc implements CustomerDAO {
	//Inyectamos DataSource
	@Autowired
	DataSource dataSource;
	

	@Override
	public List<Customer> getCustomers(){
		
		System.out.println("PASO POR DAOJDBC");
		List<Customer> customers = new ArrayList<>();
		
		// create sql statement
		String sql = "select * from product order by id";
		
		try(Connection myConn = dataSource.getConnection(); //Obtenemos conexión
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql);){
			
				// process result set
				while (myRs.next()) {
				
					// retrieve data from result set row
					int id = myRs.getInt("id");
					String nomProd = myRs.getString("nom_prod");
					int categ = myRs.getInt("categ");
					int cant = myRs.getInt("cantidad");
					int costo = myRs.getInt("costo");
					int precio = myRs.getInt("precio");
					
					// create new student object
					Customer tempCustomer = new Customer(id, nomProd, categ, cant, costo, precio);
					
					// add it to the list of students
					customers.add(tempCustomer);
					
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

	//Método para actualizar o guarfa
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		String sql = null;
		if (theCustomer.getId() == 0){// => UPDATE
			// create SQL update statement
			sql = "insert into product "
					+ "(nom_prod, categ, cantidad, costo, precio) "
					+ "values (?, ?, ?, ?, ?)";
		//if id != 0 => SAVE
		}else { 
			sql = "update product "
					+ "set nom_prod=?, categ=?, cantidad=?, costo=?, precio=? "
					+ "where id=?";
		}	
				try(Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
					
					// set the param values for the product
					myStmt.setString(1, theCustomer.getNomProd());
					myStmt.setInt(2, theCustomer.getCategoria());
					myStmt.setInt(3, theCustomer.getCant());
					myStmt.setInt(4, theCustomer.getCosto());
					myStmt.setInt(5, theCustomer.getPrecio());
					
					if(theCustomer.getId() != 0)
						myStmt.setInt(6, theCustomer.getId());
					
					// execute sql insert
					myStmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	@Override
	public Customer getCustomer(int theId) {
		Customer theCustomer = null;	
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);) {
			
			// execute statement
			ResultSet myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nomProd = myRs.getString("nom_prod");
				int categ = myRs.getInt("categ");
				int cant = myRs.getInt("cantidad");
				int costo = myRs.getInt("costo");
				int precio = myRs.getInt("precio");
				
				// use the studentId during construction
				theCustomer = new Customer(theId, nomProd, categ, cant, costo, precio);
			}
			else {
				System.out.println("Could not find customer id: " + theId);
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theCustomer;
	}

	private PreparedStatement crearStatementGetCustomer(Connection myConn, int studentId) throws SQLException {
		String sql = "select * from product where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, studentId);
		return ps;
	}
	
	@Override
	public void deleteCustomer(int theId) {
		// create sql to delete student
			String sql = "delete from product where id=?";
				
			try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql);){
					
				// set params
				myStmt.setInt(1, theId);
					
				// execute sql statement
				myStmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
	}

	

}











