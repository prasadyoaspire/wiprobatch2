package com.abc.order.exception;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class CustomerErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {

		switch (response.status()) {
		case 404:
			return new ResourceNotFoundException("Customer not found");
		case 503:
			return new ServiceNotAvailableException("Customer Api is unavailable");
		default:
			return new Exception("Exception while getting Customer details");
		}
	}
}