package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public void saveUsuario(Usuario theUsuario);

	public Usuario getUsuario(int theId);

	public void deleteUsuario(int theId);
	
}
