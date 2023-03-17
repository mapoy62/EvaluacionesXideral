package com.xideral.storetracker.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xideral.storetracker.entity.Compra;
import com.xideral.storetracker.entity.Usuario;
import com.xideral.storetracker.exception.CustomerNotFoundException;
import com.xideral.storetracker.service.CompraService;
import com.xideral.storetracker.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {

	// need to inject our customer service
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private CompraService compraService;
	
	
	//List users with or without purchases, registered in DB
	@GetMapping("/usuarios")
	public List<Usuario> findAll() {
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/usuarios/{usuarioId}")
	public Usuario getUsuario(@PathVariable int usuarioId) throws Exception {
		
		Usuario theUsuario = usuarioService.getUsuario(usuarioId);
		
		if (theUsuario == null) {
			throw new CustomerNotFoundException("Usuario id not found - " + usuarioId);
		}
		
		return theUsuario;
	}
	
	@PostMapping("/usuarios")
	public Usuario addUsuario(@RequestBody Usuario theUsuario) {
			
		theUsuario.setIdusuario(0);
		
		Usuario addUsuario = usuarioService.saveUsuario(theUsuario);
		
		return addUsuario;
	}
	
	@PutMapping("/usuarios")
	public Usuario updateUsuario(@RequestBody Usuario theUsuario) {
		
		Usuario Usuario = usuarioService.saveUsuario(theUsuario);
		
		return Usuario;
	}
	
	@DeleteMapping("/usuarios/{usuarioId}")
	public String deleteUsuario(@PathVariable int usuarioId) {
		
		Usuario tempUsuario = usuarioService.getUsuario(usuarioId);
				
		if (tempUsuario == null) {
			throw new CustomerNotFoundException("Usuario id not found - " + usuarioId);
		}
		
		usuarioService.deleteUsuario(usuarioId);
		
		return "Deleted usuario id - " + usuarioId;
	}
	
	
	
}










