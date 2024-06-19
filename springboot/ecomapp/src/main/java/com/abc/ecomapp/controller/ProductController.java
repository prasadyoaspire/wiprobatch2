package com.abc.ecomapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecomapp.entity.Product;
import com.abc.ecomapp.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {		
		productService.saveProduct(product);		
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product product) {		
		Product updatedProduct = productService.updateProduct(product);	
		return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
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
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> removeProduct(@PathVariable("productId") int productId) {		
		productService.deleteProduct(productId);	
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
