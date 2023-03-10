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

import com.luv2code.springdemo.entity.Product;
//import com.luv2code.web.jdbc.Student;

@Repository
public class ProductDAOJdbc implements ProductDAO {
	//Inyectamos DataSource
	@Autowired
	DataSource dataSource;
	

	@Override
	public List<Product> getProducts(){
		
		System.out.println("PASO POR DAOJDBC");
		List<Product> products = new ArrayList<>();
		
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
					Product tempProduct = new Product(id, nomProd, categ, cant, costo, precio);
					
					// add it to the list of students
					products.add(tempProduct);
					
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	//Método para actualizar o guarfa
	@Override
	public void saveProduct(Product theProduct) {
		
		String sql = null;
		if (theProduct.getId() == 0){// => UPDATE
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
					myStmt.setString(1, theProduct.getNomProd());
					myStmt.setInt(2, theProduct.getCategoria());
					myStmt.setInt(3, theProduct.getCant());
					myStmt.setInt(4, theProduct.getCosto());
					myStmt.setInt(5, theProduct.getPrecio());
					
					if(theProduct.getId() != 0)
						myStmt.setInt(6, theProduct.getId());
					
					// execute sql insert
					myStmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

	@Override
	public Product getProduct(int theId) {
		Product theProduct = null;	
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = crearStatementGetProduct(myConn, theId);) {
			
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
				theProduct = new Product(theId, nomProd, categ, cant, costo, precio);
			}
			else {
				System.out.println("Could not find customer id: " + theId);
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theProduct;
	}

	private PreparedStatement crearStatementGetProduct(Connection myConn, int productId) throws SQLException {
		String sql = "select * from product where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, productId);
		return ps;
	}
	
	@Override
	public void deleteProduct(int theId) {
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











