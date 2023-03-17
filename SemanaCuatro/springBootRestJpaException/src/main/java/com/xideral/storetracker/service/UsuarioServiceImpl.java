package com.xideral.storetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xideral.storetracker.dao.UsuarioDAO;
import com.xideral.storetracker.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	// need to inject customer dao
	@Autowired
	//Indicamos qué inyectar -- Inyectamos con JDBC
	@Qualifier("usuarioDAOJpa")
	private UsuarioDAO usuarioDAO;
	
	@Override
	@Transactional
	public List<Usuario> getUsuarios() {
		return usuarioDAO.getUsuarios();
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario theUsuario) {
		Usuario usuario = usuarioDAO.saveUsuario(theUsuario);
		return usuario;
	}

	@Override
	@Transactional
	public Usuario getUsuario(int theId) {
		
		return usuarioDAO.getUsuario(theId);
	}

	@Override
	@Transactional
	public void deleteUsuario(int theId) {
		
		usuarioDAO.deleteUsuario(theId);
	}
}





