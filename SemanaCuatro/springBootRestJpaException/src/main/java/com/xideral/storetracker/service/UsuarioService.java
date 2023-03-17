package com.xideral.storetracker.service;

import java.util.List;

import com.xideral.storetracker.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public Usuario saveUsuario(Usuario theUsuario);

	public Usuario getUsuario(int theId);

	public void deleteUsuario(int theId);
	
}
