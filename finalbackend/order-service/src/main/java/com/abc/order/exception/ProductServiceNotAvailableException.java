package com.abc.order.exception;

public class ProductServiceNotAvailableException extends RuntimeException {

	public ProductServiceNotAvailableException(String msg) {
		super(msg);
	}
}
