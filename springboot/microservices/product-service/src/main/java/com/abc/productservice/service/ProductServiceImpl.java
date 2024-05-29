package com.abc.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.productservice.entity.Product;
import com.abc.productservice.exception.ResourceNotFoundException;
import com.abc.productservice.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	@Override
	public Product findProductById(int productId) {
	
		Optional<Product> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: "+productId);
		}		
		Product product = optionalProduct.get();
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
	
		return productRepository.findAll();
	}

}
