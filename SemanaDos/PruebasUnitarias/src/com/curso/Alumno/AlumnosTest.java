package com.curso.Alumno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class AlumnosTest {

	@DisplayName("Dado un alumno para crear, esperamos que se cree")
	@Test
	void testCreaAlumno() {
		
		AlumnoInd alu2 = new AlumnoInd("Sergio", 12, 9.2);
		
		//assertNotNull(alu1);
		assertNotNull(alu2);
		assertEquals("Sergio", alu2.getNombre());
		assertEquals(12, alu2.getEdad());
		assertEquals(9.2, alu2.getPromedio());
	}
	
	@DisplayName("Crear un grupo para obtener promedios de edades y calif")
	@Test
	void testCreaGrupo() {
		AlumnoInd alu1 = new AlumnoInd("Vanessa", 12, 9.5);
		AlumnoInd alu2 = new AlumnoInd("Sergio", 13, 9.12);
		Grupo grupo = new Grupo();
		grupo.agregarAlumno(alu1);
		grupo.agregarAlumno(alu2);
		
		assertNotNull(grupo);
		assertEquals("Vanessa,Sergio", grupo.getNombre());
		assertEquals(12, grupo.getEdad(),0.01);
		assertEquals(9.31, grupo.getPromedio(), 0.01);
		
	}

}
