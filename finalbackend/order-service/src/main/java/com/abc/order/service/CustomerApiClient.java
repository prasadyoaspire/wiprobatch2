package com.abc.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.order.model.Customer;

@FeignClient(value = "CUSTOMER-SERVICE")
public interface CustomerApiClient {

	@GetMapping("/customer/{customerId}")
	Customer getCustomerDetails(@PathVariable("customerId") int customerId);
}
