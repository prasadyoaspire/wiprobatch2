package com.abc.ecomwebflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecomwebflux.entity.Product;
import com.abc.ecomwebflux.exception.ResourceNotFoundException;
import com.abc.ecomwebflux.repository.ProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Mono<Product> saveProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Mono<Product> findProductById(int productId) {
		
		return productRepository.findById(productId)
				.switchIfEmpty(Mono.error(new ResourceNotFoundException("Product Not found with id: "+productId)));
	}

	@Override
	public Flux<Product> findAllProducts() {
		
		return productRepository.findAll();
	}

}
