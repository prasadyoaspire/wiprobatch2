package com.abc.ecomwebflux.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Mono<String>> handleResourceNotFoundException(Exception ex) {
		
		return new ResponseEntity<>(Mono.just(ex.getMessage()),HttpStatus.NOT_FOUND);
		
	}
}
