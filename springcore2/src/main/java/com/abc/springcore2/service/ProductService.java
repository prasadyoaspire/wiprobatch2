package com.abc.springcore2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springcore2.dao.ProductDao;
import com.abc.springcore2.dto.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public void addProduct(Product product) {
		productDao.save(product);
	}
	
	public Product getProductById(int productId) {
		Product product = productDao.findById(productId);
		return product;
	}
	
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
}
