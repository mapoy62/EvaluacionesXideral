package com.inyecciondepend;

public abstract class Inyector {
	
	static Recurso r1 = new Libro("Ficcion");
	static Recurso r2 = new Pelicula("Suspenso");
	
	static Biblioteca getRecurso(String recurso, String gen) {
		Biblioteca b = null;
		switch(gen) {
		case "Ficcion":
			b = new Biblioteca(recurso, r1);
			break;
		case "Suspenso":
			b = new Biblioteca(recurso, r2);
			break;
		default:
			System.out.println("No hay género");;
		}
		return b;
	}
	
	static void inyectaLibro(Biblioteca r) {
		r.setRecurso(r1);
	}
	
	static void inyectaPelicula(Biblioteca r) {
		r.setRecurso(r2);
	}

}
