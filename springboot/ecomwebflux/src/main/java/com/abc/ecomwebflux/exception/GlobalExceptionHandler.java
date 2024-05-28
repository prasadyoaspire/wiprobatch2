package com.abc.ecomwebflux.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.abc.ecomwebflux.model.ApiError;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Mono<ApiError>> handleResourceNotFoundException(Exception ex) {
		
		ApiError apiError = new ApiError();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setStatus(HttpStatus.NOT_FOUND);
		apiError.setError(HttpStatus.NOT_FOUND.toString());
		apiError.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(Mono.just(apiError),HttpStatus.NOT_FOUND);		
	}
}
