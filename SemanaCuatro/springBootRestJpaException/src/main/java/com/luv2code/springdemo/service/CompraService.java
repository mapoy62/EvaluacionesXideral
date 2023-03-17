package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Compra;

public interface CompraService {

	public List<Compra> getCompras(int theId);

	public Compra saveCompra(Compra theCompra);

	public Compra getCompra(int theId);

	public void deleteCompra(int theId);
	
}
