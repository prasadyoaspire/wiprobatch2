package com.abc.course.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

	private String timestamp;
	private HttpStatus status;
	private String message;
	private String error;
	
}
