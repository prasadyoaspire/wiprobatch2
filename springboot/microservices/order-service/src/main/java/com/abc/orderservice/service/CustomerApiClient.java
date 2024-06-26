package com.abc.orderservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.orderservice.model.Customer;

@FeignClient(value = "CUSTOMER-SERVICE")
public interface CustomerApiClient {

	@GetMapping("/customer/get/{id}")
	public Customer getCustomerDetails(@PathVariable("id") int customerId);
}
