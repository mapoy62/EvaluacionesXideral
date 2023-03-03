package com.curso.Alumno;

import java.util.ArrayList;
import java.util.List;

public class Grupo implements AlumnoG {

	//Creamos una lista de alumnos por cada grupo
	private List<AlumnoG> alumnos;
	
	public Grupo() {
		alumnos = new ArrayList<>();
	}

	public void agregarAlumno(AlumnoG alu) {
		alumnos.add(alu);
	}
	
	public void quitarAlumno(AlumnoG alu) {
		alumnos.remove(alu);
	}
	
	
	
	@Override
	public String getNombre() {
		String nombre = "";
		for(AlumnoG alumno : alumnos) {
			nombre += alumno.getNombre() + ",";
		}
		return nombre.substring(0, nombre.length()-1);
	}

	@Override
	public int getEdad() {
		double edadProm = 0;
		for(AlumnoG alumno : alumnos) {
			edadProm += alumno.getEdad();
		}
		return (int)(edadProm/alumnos.size());
	}

	@Override
	public double getPromedio() {
		double califProm = 0;
		for(AlumnoG alumno : alumnos) {
			califProm += alumno.getPromedio();
		}
		return califProm/alumnos.size();
	}

}
