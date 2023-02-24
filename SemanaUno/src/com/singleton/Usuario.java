package com.singleton;

public class Usuario {
	//Atributos de usuario 
	String nombre;
	String colonia;
	Ventanilla vent;
	
	//Constructor de usuario
	public Usuario(String nombre, String colonia) {
		this.nombre = nombre;
		this.colonia = colonia;
	}

	public static void main(String[] args) {

		//Creamos un solo obje (ventanilla) en memoria para que sea compartido
		//por los usuarios que viven en las col1, col2, col3
		
		Usuario cliente1 = new Usuario("User1", "Col1");
		cliente1.vent = Ventanilla.getInstancia();
				
		Usuario cliente2 = new Usuario("User2", "Col1");
		cliente2.vent = Ventanilla.getInstancia();
		
		Usuario cliente3 = new Usuario("User3", "Col3");
		cliente3.vent = Ventanilla.getInstancia();
		
		Usuario cliente4 = new Usuario("User4", "Col4");
		cliente4.vent = Ventanilla.getInstancia();
		
		
		System.out.println(Ventanilla.getContador());
		System.out.println(cliente2.vent);
		
	}
	
	

}
