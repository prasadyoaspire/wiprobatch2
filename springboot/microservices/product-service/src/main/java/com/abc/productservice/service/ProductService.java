package com.abc.productservice.service;

import java.util.List;

import com.abc.productservice.entity.Product;


public interface ProductService {

	Product saveProduct(Product product);
	
	Product findProductById(int productId);
	
	List<Product> findAllProducts();
}
