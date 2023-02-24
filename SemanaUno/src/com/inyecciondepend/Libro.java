package com.inyecciondepend;

public class Libro implements Recurso {
	String genero;
	
	public Libro(String genero) {
		this.genero = genero;
	}
	
	@Override
	public void prestamo(){
		System.out.println("Libro de " + genero);
	}

}
