package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	//Obtener los productos para mostrar
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		// create sql statement
		String sql = "select * from student order by id";
		
		try(Connection myConn = dataSource.getConnection(); //Obtenemos conexión
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql);){
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String nomProd = myRs.getString("nomProd");
				int cant = myRs.getInt("cant");
				int costo = myRs.getInt("costo");
				int precio = myRs.getInt("precio");
				
				// create new student object
				Student tempStudent = new Student(id, nomProd, cant, costo, precio);
				
				// add it to the list of students
				students.add(tempStudent);				
			}
			
			return students;		
		}	
	}

	//Agregar nuevo producto
	public void addStudent(Student theStudent) throws Exception {

		String sql = "insert into student "
				   + "(nomProd, cant, costo, precio) "
				   + "values (?, ?, ?, ?)";
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
			
			// set the param values for the student
			myStmt.setString(1, theStudent.getNomProd());
			myStmt.setInt(2, theStudent.getCant());
			myStmt.setInt(3, theStudent.getCosto());
			myStmt.setInt(4, theStudent.getPrecio());
			
			// execute sql insert
			myStmt.execute();
		}
	}

	//Obtener los datos ingresados por el usuario
	public Student getStudent(String theStudentId) throws Exception {

		Student theStudent = null;
		
		int studentId= Integer.parseInt(theStudentId);	
		
		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = crearStatementGetStudent(myConn, studentId);) {
			
			// execute statement
			ResultSet myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String nomProd = myRs.getString("nomProd");
				int cant = myRs.getInt("cant");
				int costo = myRs.getInt("costo");
				int precio = myRs.getInt("precio");
				
				// use the studentId during construction
				theStudent = new Student(studentId, nomProd, cant, costo, precio);
			}
			else {
				throw new Exception("Could not find student id: " + studentId);
			}				
			
			return theStudent;
		}
	}
	
	private PreparedStatement crearStatementGetStudent(Connection myConn, int studentId) throws SQLException {
		String sql = "select * from student where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, studentId);
		return ps;
	}

	public void updateStudent(Student theStudent) throws Exception {
		
		// create SQL update statement
		String sql = "update student "
					+ "set nomProd=?, cant=?, costo=?, precio=? "
					+ "where id=?";

		try(Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement(sql);) {
		
			// set params
			myStmt.setString(1, theStudent.getNomProd());
			myStmt.setInt(2, theStudent.getCant());
			myStmt.setInt(3, theStudent.getCosto());
			myStmt.setInt(4, theStudent.getPrecio());
			myStmt.setInt(5, theStudent.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
	}

	public void deleteStudent(String theStudentId) throws Exception {
		
		// create sql to delete student
		String sql = "delete from student where id=?";
		
		try (Connection myConn = dataSource.getConnection();
			PreparedStatement myStmt = myConn.prepareStatement(sql);){
			
			// convert student id to int
			int studentId = Integer.parseInt(theStudentId);
			
			// set params
			myStmt.setInt(1, studentId);
			
			// execute sql statement
			myStmt.execute();
		}	
	}
}















