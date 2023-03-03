package com.curso.Alumno;

public class AlumnoInd implements AlumnoG {

	private String nombre;
	private int edad;
	private double promedio;

	
	
	public AlumnoInd(String nombre, int edad, double promedio) {

		this.nombre = nombre;
		this.edad = edad;
		this.promedio = promedio;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getEdad() {
		return edad;
	}

	@Override
	public double getPromedio() {
		return promedio;
	}

}
