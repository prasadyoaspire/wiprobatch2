package com.abc.product.controller;

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

import com.abc.product.entity.ProductEntity;
import com.abc.product.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<ProductEntity> addNewProduct(@RequestBody ProductEntity productEntity) {		
		productService.saveProduct(productEntity);		
		return new ResponseEntity<>(productEntity, HttpStatus.CREATED);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<ProductEntity> fetchProductDetails(@PathVariable("productId") int productId) {		
		ProductEntity productEntity = productService.findProductById(productId);		
		return new ResponseEntity<>(productEntity, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<ProductEntity> fetchAllProducts() {		
		List<ProductEntity> products = productService.findAllProducts();	
		return products;
	}
	
}
