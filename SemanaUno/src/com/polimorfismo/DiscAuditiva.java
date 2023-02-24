package com.polimorfismo;

import java.util.Scanner;

public class DiscAuditiva extends Discapacidad{
	

	@Override
	void definirDiscap() {
		System.out.println("Condición de vida que tiene ciertas limitaciones en el sentido del oido.");
	}
	
	Boolean accesibilidad() {
		Scanner ingresa = new Scanner(System.in);
		int respUser;
		
		do {
		System.out.println(
				 "\n0. Sin asistencia"
				+"\n1. Intérpete LSM ");
		respUser = ingresa.nextInt();
		}while(respUser!=1 && respUser!=0);
		
		if(respUser==1)
			return true;
		else
			return false;
	}
	
	@Override
	void asignarHerramienta() {
		if(accesibilidad()) {
			System.out.println("(ConfiguracionesManuales) H + S+S > S+5");
		}else {
			System.out.println("Si necesitas algo, no dudes en comentarlo:)");
		}
	}
}
