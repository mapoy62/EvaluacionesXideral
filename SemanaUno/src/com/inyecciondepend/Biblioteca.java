package com.inyecciondepend;

public class Biblioteca {
	
	//Atributos - Has-a
	private String nombre;
	private Recurso recurso;
	
		//Inyección por constructor
		public Biblioteca(String nombre, Recurso recurso) {
			this.nombre = nombre;
			this.recurso = recurso;
		}
		
		void prestarRecurso() {
			System.out.println(nombre + " Recurso prestado");
			recurso.prestamo();
		}
		
		public Recurso getRecurso() {
			return recurso;
		}

		//INYECCION POR SETTER
		public void setRecurso(Recurso recurso) {
			this.recurso = recurso;
		}

}
