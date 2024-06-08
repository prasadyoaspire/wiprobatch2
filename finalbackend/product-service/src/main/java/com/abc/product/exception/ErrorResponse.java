package com.abc.product.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

	private String timestamp;
	private HttpStatus status;
	private String message;
}
