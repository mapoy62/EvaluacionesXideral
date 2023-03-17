package com.xideral.storeur.service;

import java.util.List;

import com.xideral.storeur.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario theUsuario);

	public Usuario getUsuario(int theId);

	public void deleteUsuario(int theId);
	
}
