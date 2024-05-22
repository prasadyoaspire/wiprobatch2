package com.abc.springcore2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.abc.springcore2.dto.Product;
import com.abc.springcore2.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void saveProduct(Product product) {
		productService.addProduct(product);
	}
	
	public Product fetchProductDetails(int productId) {
		return productService.getProductById(productId);
	}
	
	public List<Product> fetchAllProducts() {
		return productService.getAllProducts();
	}
}
