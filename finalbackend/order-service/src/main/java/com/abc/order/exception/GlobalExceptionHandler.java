package com.abc.order.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse>  handleResourceNotFoundException(Exception ex) {	
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setMessage(ex.getMessage());	
		
		ResponseEntity<ErrorResponse> responseEntity = new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		return responseEntity;
	}			
}
