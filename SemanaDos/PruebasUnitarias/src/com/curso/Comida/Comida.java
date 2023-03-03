package com.curso.Comida;

import java.util.HashMap;

public class Comida {
	int ings = 0;
	
	//Creamos una lista  de ingredientes con su nombre y valor nutricional aportado
	private HashMap<String, Integer> ingredientes = new HashMap<>();

	//Método para crear un comida/dieta
	public Integer crearComida(String nomb, Integer valorNut) {
		//Agregar al menos un ingrediente para la comida
		return ingredientes.put(nomb, valorNut);
	}
	
	//Total de ingrediente agregados
	public int totalIngredientes() {
		System.out.println("Número de ingredientes agregados: " + ingredientes.size());
		for (String i : ingredientes.keySet()) {
		      System.out.println(i);
		    }
		for (Integer i : ingredientes.values()) {
		      System.out.println(i);
		    }
		return ingredientes.size();
		
	}

	//Método para obtener valor nutricional comida/dieta
	public Integer getValorNutTotal(String ing) {
		System.out.println("The Value is: " + ingredientes.get(ing));
		return ingredientes.get(ing);
	}
	
	//Método para mostraringredientes
	public void getComida() {
		System.out.println(ingredientes);
	}
	
	



	

}
