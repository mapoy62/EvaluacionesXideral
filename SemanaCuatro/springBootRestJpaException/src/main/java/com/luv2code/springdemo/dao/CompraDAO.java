package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Compra;

public interface CompraDAO {

	public List<Compra> getCompras(int theId);

	public Compra saveCompra(Compra theCompra);

	public Compra getCompra(int theId);

	public void deleteCompra(int theId);
	
}
