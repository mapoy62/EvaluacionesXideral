package com.inyecciondepend;

public class Pelicula implements Recurso{
	String genero;
	
	public Pelicula(String genero) {
		this.genero = genero;
	}
	
	@Override
	public void prestamo(){
		System.out.println("Película independiente de " + genero);
	}
}
