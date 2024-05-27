package com.abc.ecomapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String>  handleProductNotFoundException(Exception ex) {		
		ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}		
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String>  handleOrderNotFoundException(Exception ex) {		
		ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
		return responseEntity;
	}	
	
//	@ExceptionHandler(CustomerNotFoundException.class)
//	public ResponseEntity<String>  handleCusotmerNotFoundException(Exception ex) {		
//		ResponseEntity<String> responseEntity = new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//		return responseEntity;
//	}	
	
}
