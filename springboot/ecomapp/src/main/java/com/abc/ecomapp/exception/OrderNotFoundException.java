package com.abc.ecomapp.exception;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
