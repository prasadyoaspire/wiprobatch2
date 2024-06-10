package com.abc.order.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 404:
			return new ResourceNotFoundException("Product not found");
		case 503:
			return new ProductServiceNotAvailableException("Product Api is unavailable");
		default:
			return new Exception("Exception while getting product details");
		}
	}
}
