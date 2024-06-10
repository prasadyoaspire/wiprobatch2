package com.abc.order.exception;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class ProductErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 404:
			return new ResourceNotFoundException("Product not found");
		case 503:
			return new ServiceNotAvailableException("Product Api is unavailable");
		default:
			return new Exception("Exception while getting product details");
		}
	}
}
