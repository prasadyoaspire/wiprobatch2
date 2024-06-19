package com.abc.ecomapp.service;

import java.util.List;

import com.abc.ecomapp.entity.Product;
import com.abc.ecomapp.exception.ProductNotFoundException;

public interface ProductService {

	Product saveProduct(Product product);
	
	Product findProductById(int productId) throws ProductNotFoundException;
	
	List<Product> findAllProducts();
	
	Product updateProduct(Product product);
	
	void deleteProduct(int productId);
}
