package com.curso.Comida;

public class Ingrediente implements Component{
	private String nombre;
	private int valorNutri;
	
	public Ingrediente(String nombre, int valorNutri) {
		this.nombre = nombre;
		this.valorNutri = valorNutri;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getValorNut() {
		return valorNutri;
	}
	
	
	
}
