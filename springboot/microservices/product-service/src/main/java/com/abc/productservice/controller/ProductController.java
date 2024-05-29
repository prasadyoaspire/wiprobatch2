package com.abc.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.productservice.entity.Product;
import com.abc.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {		
		productService.saveProduct(product);		
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> fetchProductDetails(@PathVariable("productId") int productId) {		
		Product product = productService.findProductById(productId);		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Product> fetchAllProducts() {		
		List<Product> products = productService.findAllProducts();	
		return products;
	}
	
}
