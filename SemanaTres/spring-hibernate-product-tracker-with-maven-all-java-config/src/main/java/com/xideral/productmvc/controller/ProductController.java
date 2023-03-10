package com.xideral.productmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xideral.productmvc.entity.Product;
import com.xideral.productmvc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	// need to inject our product service
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public String listProducts(Model theModel) {
		
		// get products from the service
		List<Product> theProducts = productService.getProducts();
				
		// add the products to the model
		theModel.addAttribute("products", theProducts);
		
		return "list-products";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Product theProduct = new Product();
		
		theModel.addAttribute("product", theProduct);
		
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct) {
		
		// save the product using our service
		productService.saveProduct(theProduct);	
		
		return "redirect:/product/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("productId") int theId,
									Model theModel) {
		
		// get the product from our service
		Product theProduct = productService.getProduct(theId);	
		
		// set product as a model attribute to pre-populate the form
		theModel.addAttribute("product", theProduct);
		
		// send over to our form		
		return "product-form";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") int theId) {
		
		// delete the product
		productService.deleteProduct(theId);
		
		return "redirect:/product/list";
	}
}










