package com.luv2code.springdemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

	private int idusuario;

	private String nombre;

	private String apellido;

	private String correo;
		
}





