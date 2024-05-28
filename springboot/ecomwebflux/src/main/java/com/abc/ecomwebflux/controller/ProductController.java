package com.abc.ecomwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecomwebflux.entity.Product;
import com.abc.ecomwebflux.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public Mono<Product> addNewProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/{productId}")
	public Mono<Product> fetchProductDetails(@PathVariable int productId) {
		return productService.findProductById(productId);
	}
	
	@GetMapping("/all")
	public Flux<Product> fetchAllProducts() {
		return productService.findAllProducts();
	}
}
