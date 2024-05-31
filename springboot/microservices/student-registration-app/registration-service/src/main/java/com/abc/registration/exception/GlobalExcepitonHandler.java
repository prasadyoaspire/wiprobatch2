package com.abc.registration.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExcepitonHandler {

	@ExceptionHandler(ResourseNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(Exception e, WebRequest request) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setTimestamp(LocalDateTime.now().toString());
		errorResponse.setStatus(HttpStatus.NOT_FOUND);
		errorResponse.setMessage(HttpStatus.NOT_FOUND.toString());
		errorResponse.setError(e.getMessage());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
}
