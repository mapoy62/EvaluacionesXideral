package com.polimorfismo.interfaces;

import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Discapacidad persona = getPersona();
		
		System.out.println(persona.getClass().getSimpleName());
		persona.definirDiscap();
		persona.asignarHerramienta();
	}
		
		private static Discapacidad getPersona() {
			Discapacidad[] persona = { new DiscVisual(), new DiscAuditiva(), new DiscFisica() };
			int entero = new Random().nextInt(persona.length);
			return persona[entero];
		}
	}

