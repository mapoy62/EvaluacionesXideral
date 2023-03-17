package com.xideral.storeur.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compra {

	private int idcompra;
	
	private int num_prod;

	private String fecha;

	private Double total;

	private Double descuento;

	private Usuario idusuario;
	
	public static Compra agregarDescuento(Compra comp, Double descuento) {
		comp.setDescuento(comp.getTotal()-(comp.getTotal()- descuento));
		return comp;
	}

	
}





