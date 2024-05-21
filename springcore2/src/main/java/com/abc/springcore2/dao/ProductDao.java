package com.abc.springcore2.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.abc.springcore2.dto.Product;

public class ProductDao {

	private List<Product> products ;
	
	public ProductDao() {
		products = new ArrayList<>();
		
		Product product1 = new Product();
		product1.setProductId(10);
		product1.setProductName("SamsungF20");
		product1.setProductPrice(50000);
		
		Product product2 = new Product();
		product2.setProductId(20);
		product2.setProductName("IPhoneX");
		product2.setProductPrice(80000);
		
		Product product3 = new Product();
		product3.setProductId(30);
		product3.setProductName("IPhoneZ+");
		product3.setProductPrice(70000);
		
		products.add(product1);
		products.add(product2);
		products.add(product3);
	}
	
	public void save(Product product) {
		products.add(product);
	}
	
	public Product findById(int productId) {
		
		Optional<Product> optionalProduct = products.stream().filter(p-> p.getProductId() == productId).findFirst();
		if(optionalProduct.isEmpty()) {
			// will throw exception
		}
		Product product = optionalProduct.get();
		return product;
	}
	
	public List<Product> findAll() {
		return products;
	}
	
}
