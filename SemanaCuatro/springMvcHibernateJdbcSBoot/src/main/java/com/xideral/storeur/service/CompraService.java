package com.xideral.storeur.service;

import java.util.List;

import com.xideral.storeur.entity.Compra;

public interface CompraService {

	public List<Compra> getCompras();

	public void saveCompra(Compra theCompra);

	public Compra getCompra(int theId);

	public void deleteCompra(int theId);
	
}
