package com.xideral.storeur.rest;

import java.util.List;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xideral.storeur.entity.Compra;
import com.xideral.storeur.service.CompraService;

@Controller
@RequestMapping("/api/usuarios")
public class CompraRestController {


	// need to inject our customer service
	@Autowired
	private CompraService compraService;
	
	@GetMapping("/list-compras")
	public String listCompras(Model theModel) {
		
		// get compras from the service
		List<Compra> theCompras = compraService.getCompras();
				
		// add the customers to the model
		theModel.addAttribute("compras", theCompras);
		
		return "list-compras";
	}
	
	@GetMapping("/showFormForAddPurch")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Compra theCompra = new Compra();
		
		theModel.addAttribute("compra", theCompra);
		
		return "compra-form";
	}
	
	@PostMapping("/savePurch")
	public String saveCustomer(@ModelAttribute("compra") Compra theCompra) {
		
		// save the customer using our service
		compraService.saveCompra(theCompra);	
		
		return "redirect:/compra/list-compras";
	}
	
	@GetMapping("/showFormForUpdatePurch")
	public String showFormForUpdate(@RequestParam("compraId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Compra theCompra = compraService.getCompra(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("compra", theCompra);
		
		// send over to our form		
		return "compra-form";
	}
	
	@GetMapping("/deletePurch")
	public String deleteCompra(@RequestParam("compraId") int theId) {
		
		// delete the customer
		compraService.deleteCompra(theId);
		
		return "redirect:/compra/list-compras";
	}
	
}










