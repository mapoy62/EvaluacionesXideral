package com.luv2code.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Compra;
import com.luv2code.springdemo.entity.Usuario;


@Repository
public class CompraDAOJdbc implements CompraDAO {
	//Inyectamos DataSource
	@Autowired
	DataSource dataSource;
	

	@Override
	public List<Compra> getCompras(int theId){
		
		System.out.println("PASO POR CompraDAOJDBC");
		List<Compra> compras = new ArrayList<>();
		
		//Compra theCompra = null;	
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = crearStatementGetCompras(myConn, theId);){
			
			// execute statement
			ResultSet myRs = myStmt.executeQuery();
				// process result set
				while (myRs.next()) {
					
					// retrieve data from result set row
					int id = myRs.getInt("idcompra");
					int num_prod = myRs.getInt("num_prod");
					String fecha = myRs.getString("fecha");
					Double total = myRs.getDouble("total");
					Double descuento = myRs.getDouble("descuento");
					
					ResultSet rs = myStmt.executeQuery(
						    "SELECT usuario " +
						    "WHERE idusuario = ?");
					((PreparedStatement) rs).setInt(1, theId);
					rs.next();
					Struct user = (Struct)rs.getObject("usuario");
					
					
					
					// create new purchase object
					Compra tempCompra = new Compra(id, num_prod, fecha, total, descuento, (Usuario) user);
					
					// add it to the list of purchases
					compras.add(tempCompra);
					
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return compras;
	}
	
	private PreparedStatement crearStatementGetCompras(Connection myConn, int usuarioId) throws SQLException {
		String sql = "select * from compra where idusuario=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, usuarioId);
		return ps;
	}

	//Method to update or save a new purchase
	@Override
	public Compra saveCompra(Compra theCompra) {
		
		String sql = null;
		if (theCompra.getIdcompra() == 0){// => SAVE
			// create SQL update statement
			sql = "insert into compra "
					+ "(num_prod, fecha, total, descuento, idusuario) "
					+ "values (?, ?, ?, ?, ?)";
		//if id != 0 => UPDATE
		}else { 
			sql = "update compra "
					+ "set num_prod=?, fecha=?, total=?, descuento=?, idusuario=?"
					+ "where idcompra=?";
		}	
				try(Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
					
					// set the param values for the product
					myStmt.setInt(1, theCompra.getNum_prod());
					myStmt.setString(2, theCompra.getFecha());
					myStmt.setDouble(3, theCompra.getTotal());
					myStmt.setDouble(4, theCompra.getDescuento());
					 
					myStmt.setInt(5,theCompra.getIdusuario().getIdusuario() );
					
					/*
					ResultSet rs = myStmt.executeQuery(
						    "select * from compra where idusuario.idusuario = theId");
						rs.next();
						Usuario userid = (Usuario)rs.getObject("idusuario");
						return userid.idusuario;
					*/
						
					if(theCompra.getIdcompra() != 0)
						myStmt.setInt(6, theCompra.getIdcompra());
					
					// execute sql insert
					myStmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return theCompra;//////////////////////////////////////////////////////////////
	}


	@Override
	public Compra getCompra(int theId) {
		Compra theCompra = null;	
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = crearStatementGetCompra(myConn, theId);) {
			
			// execute statement
			ResultSet myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				int num_prod = myRs.getInt("num_producto");
				String fecha = myRs.getString("fecha");
				Double total = myRs.getDouble("total");
				Double descuento = myRs.getDouble("descuento");
				//MAP FOR RETRIVE DATA FROM OUU OBJECT
				Usuario user = (Usuario)myRs.getObject("idusuario");
				
				// use the usuarioId during construction
				theCompra = new Compra(theId, num_prod, fecha, total, descuento, user);
			}
			else {
				System.out.println("Could not find purchase id: " + theId);
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theCompra;
	}

	private PreparedStatement crearStatementGetCompra(Connection myConn, int compraId) throws SQLException {
		String sql = "select * from compra where idcompra=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, compraId);
		return ps;
	}
	
	@Override
	public void deleteCompra(int theId) {
		// create sql to delete purchase
			String sql = "delete from compra where idcompra=?";
				
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











