package com.abc.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.order.exception.CustomerErrorDecoder;
import com.abc.order.model.Customer;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

//@FeignClient(value = "CUSTOMER-SERVICE", configuration = {CustomerErrorDecoder.class}, fallback = CustomerApiClientFallback.class)
@FeignClient(value = "CUSTOMER-SERVICE")
@CircuitBreaker(name="customerClient", fallbackMethod = "getCustomerDetailsFallBack")
public interface CustomerApiClient {

	@GetMapping("/customer/{customerId}")
	Customer getCustomerDetails(@PathVariable("customerId") int customerId);
	
	default Customer getCustomerDetailsFallBack(Exception e) {
		return new Customer();
	}
}
