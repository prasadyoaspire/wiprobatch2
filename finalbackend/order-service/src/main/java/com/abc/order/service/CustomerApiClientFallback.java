package com.abc.order.service;

import com.abc.order.model.Customer;

public class CustomerApiClientFallback {

	Customer getCustomerDetailsFallBack(Exception e) {
		return new Customer();
	}
}
