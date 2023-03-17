package com.xideral.storetracker.dao;

import java.util.List;

import com.xideral.storetracker.entity.Usuario;

public interface UsuarioDAO {

	public List<Usuario> getUsuarios();

	public Usuario saveUsuario(Usuario theUsuario);

	public Usuario getUsuario(int theId);

	public void deleteUsuario(int theId);
	
}
