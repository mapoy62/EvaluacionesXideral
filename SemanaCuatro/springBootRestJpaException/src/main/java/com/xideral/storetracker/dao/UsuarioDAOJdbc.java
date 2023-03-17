package com.xideral.storetracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xideral.storetracker.entity.Usuario;

@Repository
public class UsuarioDAOJdbc implements UsuarioDAO {
	//Inyectamos DataSource
	@Autowired
	DataSource dataSource;
	

	@Override
	public List<Usuario> getUsuarios(){
		
		System.out.println("PASO POR UsuarioDAOJDBC");
		List<Usuario> usuarios = new ArrayList<>();
		
		// create sql statement
		String sql = "select * from usuario order by idusuario";
		
		try(Connection myConn = dataSource.getConnection(); //Obtenemos conexión
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql);){
			
				// process result set
				while (myRs.next()) {
				
					// retrieve data from result set row
					int id = myRs.getInt("idusuario");
					String nombre = myRs.getString("nombre");
					String apellido = myRs.getString("apellido");
					String correo = myRs.getString("correo");
					
					
					// create new student object
					Usuario tempUsuario = new Usuario(id, nombre, apellido, correo);
					
					// add it to the list of students
					usuarios.add(tempUsuario);
					
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	//Método para actualizar o guarfa
	@Override
	public Usuario saveUsuario(Usuario theUsuario) {
		
		String sql = null;
		if (theUsuario.getIdusuario() == 0){// => UPDATE
			// create SQL update statement
			sql = "insert into usuario "
					+ "(nombre, apellido, correo) "
					+ "values (?, ?, ?)";
		//if id != 0 => SAVE
		}else { 
			sql = "update usuario "
					+ "set nombre=?, apellido=?, correo=? "
					+ "where idusuario=?";
		}	
				try(Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
					
					// set the param values for the product
					myStmt.setString(1, theUsuario.getNombre());
					myStmt.setString(2, theUsuario.getApellido());
					myStmt.setString(3, theUsuario.getCorreo());
					
					
					if(theUsuario.getIdusuario() != 0)
						myStmt.setInt(4, theUsuario.getIdusuario());
					
					// execute sql insert
					myStmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		return theUsuario;//////////////////////////////////////////////////////////////
	}

	@Override
	public Usuario getUsuario(int theId) {
		Usuario theUsuario = null;	
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = crearStatementGetUsuario(myConn, theId);) {
			
			// execute statement
			ResultSet myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nombre = myRs.getString("nombre");
				String apellido = myRs.getString("apellido");
				String correo = myRs.getString("correo");
				
				// use the studentId during construction
				theUsuario = new Usuario(theId, nombre, apellido, correo);
			}
			else {
				System.out.println("Could not find user id: " + theId);
			}				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theUsuario;
	}

	private PreparedStatement crearStatementGetUsuario(Connection myConn, int usuarioId) throws SQLException {
		String sql = "select * from usuario where idusuario=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, usuarioId);
		return ps;
	}
	
	@Override
	public void deleteUsuario(int theId) {
		// create sql to delete user
			String sql = "delete from usuario where idusuario=?";
				
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











