package com.curso.Comida;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Dieta {

	@Test
	void ComidaconIngrediente() {
		//Creamos un platillo/comida
		Comida comida = new Comida();
		
		//Agregar ingredientes para hacer una comida
		comida.crearComida("Papa", 200);
		comida.crearComida("Carne", 1000);
		 
		//Comida debe tener al menos un ingrediente y ser creada
		assertNotNull(comida);
		
		//Ingrediente debe tener más de 0 calorías
		assertNotEquals(comida.totalIngredientes() ,0);
	}
	
	

	@Test
	void testDietaDeficiente() {
		Comida comida = new Comida();
		comida.getValorNutTotal("Papa");
		
		assertNotNull(comida.getValorNutTotal("Papa"));
	}
	
	/*
	@Test
	void testDietaExagerada() {
		
	}*/

}
