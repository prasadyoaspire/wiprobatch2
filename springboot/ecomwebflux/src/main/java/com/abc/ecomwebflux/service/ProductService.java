package com.abc.ecomwebflux.service;

import com.abc.ecomwebflux.entity.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	Mono<Product> saveProduct(Product product);
	
	Mono<Product> findProductById(int productId);
	
	Flux<Product> findAllProducts();
}
