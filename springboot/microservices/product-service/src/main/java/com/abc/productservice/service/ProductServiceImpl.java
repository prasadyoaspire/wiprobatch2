package com.abc.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.productservice.entity.ProductEntity;
import com.abc.productservice.exception.ResourceNotFoundException;
import com.abc.productservice.model.Product;
import com.abc.productservice.repository.ProductRepository;
import com.abc.productservice.util.ProductMapper;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		
		//convert model object to entity object
		ProductEntity productEntity = ProductMapper.mapToEntity(product);
		
		productRepository.save(productEntity);
		
		product.setProductId(productEntity.getProductId());
		return product;
	}

	@Override
	public Product findProductById(int productId) {
	
		Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ResourceNotFoundException("Product not existing with id: "+productId);
		}		
		ProductEntity productEntity = optionalProduct.get();
		
		//convert entity to model
		Product product = ProductMapper.mapToModel(productEntity);
		
		return product;
	}

	@Override
	public List<Product> findAllProducts() {
		
		List<ProductEntity> productEntityList = productRepository.findAll();
		
		//convert entity list to model list
		List<Product> productList = ProductMapper.mapToModelList(productEntityList);
			
		return productList;
	}

}
