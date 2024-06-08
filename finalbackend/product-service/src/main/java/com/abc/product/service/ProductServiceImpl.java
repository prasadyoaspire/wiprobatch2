package com.abc.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.product.entity.ProductEntity;
import com.abc.product.exception.ResourceNotFoundException;
import com.abc.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		
		return productRepository.save(product);
	}

	@Override
	public ProductEntity findProductById(int productId) {
		Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: "+productId);
		}
		ProductEntity product = optionalProduct.get();
		return product;
	}

	@Override
	public List<ProductEntity> findAllProducts() {
		
		return productRepository.findAll();
	}

}
