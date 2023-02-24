package com.polimorfismo;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		//Persona que apunta a un tipo de discapacidad
		Discapacidad persona = getPersona();
		
		System.out.println(persona.getClass().getSimpleName());
		persona.definirDiscap();
		persona.asignarHerramienta();
	}
		
		//Método que asigna discapacidad a persona
		private static Discapacidad getPersona() {
			Discapacidad[] persona = { new DiscVisual(), new DiscAuditiva(), new DiscFisica() };
			int entero = new Random().nextInt(persona.length);
			return persona[entero];
		}
	}

