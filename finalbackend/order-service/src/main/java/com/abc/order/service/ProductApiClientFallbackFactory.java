package com.abc.order.service;

import com.abc.order.model.Product;

public class ProductApiClientFallbackFactory {

	public Product getProductDetialsFallBack(Exception e) {
		return new Product();
	}
}
