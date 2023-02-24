package com.inyecciondepend;

public class Principal {

	public static void main(String[] args) {
		
		Biblioteca b2 = Inyector.getRecurso("Biblioteca Vasconcelos - ","Ficcion");
		b2.prestarRecurso();
		
		Biblioteca b3 = Inyector.getRecurso("Biblioteca Vasconcelos - ","Ficcion");
		b3.prestarRecurso();
		
		Inyector.inyectaPelicula(b2);
		b2.prestarRecurso();
	}

}
