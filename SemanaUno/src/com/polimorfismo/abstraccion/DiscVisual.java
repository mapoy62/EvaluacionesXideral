package com.polimorfismo.abstraccion;

import java.util.Scanner;

public class DiscVisual extends Discapacidad{
	
	@Override
	void definirDiscap() {
		System.out.println("Condición de vida que tiene ciertas limitaciones en el sentido de la vista, "
				+ "puede ser adquirida o congénita.");
	}

	Boolean accesibilidad() {
		Scanner ingresa = new Scanner(System.in);
		int respUser;
		
		do {
		System.out.println(
				 "\n0. Lector de pantalla "
				+"\n1. Braille");
		respUser = ingresa.nextInt();
		}while(respUser!=1 && respUser!=0);
		
		if(respUser==0)
			return true;
		else
			return false;
	}
	
	void asignarHerramienta() {
		if(accesibilidad()) {
			System.out.println("*Se lee en voz alta* ¡Bienvenido!");
		}else {
			System.out.println("*Imaginando existe teléfono con pantalla de braille");
			System.out.println("   .   . .  .. .  .  ..  . .. .  \r\n"
					+ "   .  .   .  . .   .  . .   .  . \r\n"
					+ " .          .  ..    .        .  ");
		}
	}

}
