package com.abc.springcore2.controller;

import java.util.List;

import com.abc.springcore2.dto.Product;
import com.abc.springcore2.service.ProductService;

public class ProductController {

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
