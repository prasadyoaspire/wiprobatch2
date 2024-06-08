package com.abc.product.service;

import java.util.List;

import com.abc.product.entity.ProductEntity;

public interface ProductService {

	ProductEntity saveProduct(ProductEntity product);
	
	ProductEntity findProductById(int productId);
	
	List<ProductEntity> findAllProducts();
}
