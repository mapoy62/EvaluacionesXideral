package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/usuarios")
public class CompraRestController {

	// need to inject our customer service
	@Autowired
	private CompraService compraService;
	
	
	//Shoping LIST from USER
	@GetMapping("/detalles/{usuarioId}/compras")
	public List<Compra> findAll1(@PathVariable int usuarioId) {
		return compraService.getCompras(usuarioId);
	}
	
	//Details of ONE shopping
	@GetMapping("/compras/{compraId}")
	public Compra getCompra(@PathVariable int compraId) throws Exception {
		
		Compra theCompra = compraService.getCompra(compraId);
		
		if (theCompra == null) {
			throw new CustomerNotFoundException("Compra id not found - " + compraId);
		}
		
		return theCompra;
	}
	
	@PostMapping("/{usuarioId}/compras")
	public Compra addCompra(@RequestBody Compra theCompra) {
			
		theCompra.setIdcompra(0);
		
		Compra addCompra = compraService.saveCompra(theCompra);
		
		return addCompra;
	}
	
	@PutMapping("/detalles/{usuarioId}/compras")
	public Compra updateCompra(@RequestBody Compra theCompra) {
		
		Compra Compra = compraService.saveCompra(theCompra);
		
		return Compra;
	}
	
	@DeleteMapping("/detalles/{usuarioId}/compras/{compraId}")
	public String deleteCompra(@PathVariable int compraId) {
		
		Compra tempCompra = compraService.getCompra(compraId);
				
		if (tempCompra == null) {
			throw new CustomerNotFoundException("Compra id not found - " + compraId);
		}
		
		compraService.deleteCompra(compraId);
		
		return "Deleted compra id - " + compraId;
	}
	
}










