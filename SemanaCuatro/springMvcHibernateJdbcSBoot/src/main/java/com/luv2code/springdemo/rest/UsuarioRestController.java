package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Compra;
import com.luv2code.springdemo.entity.Usuario;
import com.luv2code.springdemo.exception.CustomerNotFoundException;
import com.luv2code.springdemo.service.CompraService;
import com.luv2code.springdemo.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {


	// need to inject our customer service
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/list-usuarios")
	public String listUsuarios(Model theModel) {
		
		// get customers from the service
		List<Usuario> theUsuarios = usuarioService.getUsuarios();
				
		// add the customers to the model
		theModel.addAttribute("usuarios", theUsuarios);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Usuario theUsuario = new Usuario();
		
		theModel.addAttribute("usuario", theUsuario);
		
		return "customer-form";
	}
	
	@PostMapping("/saveUsuario")
	public String saveUsuario(@ModelAttribute("usuario") Usuario theUsuario) {
		
		// save the customer using our service
		usuarioService.saveUsuario(theUsuario);	
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("usuarioId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Usuario theUsuario = usuarioService.getUsuario(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("usuario", theUsuario);
		
		// send over to our form		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteUsuario(@RequestParam("usuarioId") int theId) {
		
		// delete the customer
		usuarioService.deleteUsuario(theId);
		
		return "redirect:/customer/list";
	}
}










