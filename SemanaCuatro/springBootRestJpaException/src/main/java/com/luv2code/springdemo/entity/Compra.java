package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcompra")
	private int idcompra;
	
	@Column(name="num_prod")
	private int num_prod;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="total")
	private Double total;
	
	@Column(name="descuento")
	private Double descuento;
		
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario idusuario;
	
	public static Compra agregarDescuento(Compra comp, Double descuento) {
		comp.setDescuento(comp.getTotal()-(comp.getTotal()- descuento));
		return comp;
	}

	
}





