package com.abc.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.order.exception.ProductErrorDecoder;
import com.abc.order.exception.ServiceNotAvailableException;
import com.abc.order.model.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(value = "PRODUCT-SERVICE",configuration = {ProductErrorDecoder.class}, fallbackFactory = ProductApiClientFallbackFactory.class)
//@CircuitBreaker(name="productClient", fallbackMethod = "ProductApiClientFallbackFactory")
public interface ProductApiClient {

	@GetMapping("/product/{productId}")
	Product getProductDetials(@PathVariable("productId") int productId);	
	
}
