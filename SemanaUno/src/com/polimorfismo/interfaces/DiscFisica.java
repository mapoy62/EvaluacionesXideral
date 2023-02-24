package com.polimorfismo.interfaces;

import java.util.Scanner;

public class DiscFisica implements Discapacidad {
	
	String extremidad;
	
	@Override
	public void definirDiscap() {
		System.out.println("\nCondición de vida que tiene ciertas limitaciones en alguna extremidad, puede ser parcial o total.");
	}
	
	Boolean accesibilidad() {
		Scanner ingresa = new Scanner(System.in);
		int respUser;
		
		do {
		System.out.println("¿Necesita silla de ruedas?"
				+ "\n0. No "
				+ "\n1. Sí");
		respUser = ingresa.nextInt();
		}while(respUser!=1 && respUser!=0);
		
		if(respUser==1)
			return true;
		else
			return false;
	}
	
	@Override
	public void asignarHerramienta() {
		if(accesibilidad()) {
			System.out.println("En camino por la silla de ruedas... 🦽.🦽.🦽");
		}else {
			System.out.println("Si necesitas algo, no dudes en comentarlo:)");
		}
	}
	

}
