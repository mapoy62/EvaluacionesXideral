package com.xideral.storetracker.dao;

import java.util.List;

import com.xideral.storetracker.entity.Compra;

public interface CompraDAO {

	public List<Compra> getCompras(int theId);

	public Compra saveCompra(Compra theCompra);

	public Compra getCompra(int theId);

	public void deleteCompra(int theId);
	
}
