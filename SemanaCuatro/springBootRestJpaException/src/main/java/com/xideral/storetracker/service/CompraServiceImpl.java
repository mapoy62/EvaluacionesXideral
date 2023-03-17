package com.xideral.storetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xideral.storetracker.dao.CompraDAO;
import com.xideral.storetracker.dao.UsuarioDAO;
import com.xideral.storetracker.entity.Compra;

@Service
public class CompraServiceImpl implements CompraService {

	// need to inject customer dao
	@Autowired
	//Indicamos qué inyectar -- Inyectamos con JDBC
	@Qualifier("compraDAOJpa")
	private CompraDAO compraDAO;
	
	@Override
	@Transactional
	public List<Compra> getCompras(int theId) {
		return compraDAO.getCompras(theId);
	}

	@Override
	@Transactional
	public Compra saveCompra(Compra theCompra) {
		Compra compra = compraDAO.saveCompra(theCompra);
		return compra;
	}

	
	@Override
	@Transactional
	public Compra getCompra(int theId) {
		
		return compraDAO.getCompra(theId);
	}
	
	@Override
	@Transactional
	public void deleteCompra(int theId) {
		
		compraDAO.deleteCompra(theId);
	}
}





