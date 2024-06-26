package com.abc.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.orderservice.model.Product;

@FeignClient(value = "PRODUCT-SERVICE")
public interface ProductApiClient {

	@GetMapping("/product/{productId}")
	Product getProductDetials(@PathVariable("productId") int productId);
}
