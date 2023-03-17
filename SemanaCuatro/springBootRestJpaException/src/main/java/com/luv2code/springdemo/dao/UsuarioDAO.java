package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Usuario;

public interface UsuarioDAO {

	public List<Usuario> getUsuarios();

	public Usuario saveUsuario(Usuario theUsuario);

	public Usuario getUsuario(int theId);

	public void deleteUsuario(int theId);
	
}
