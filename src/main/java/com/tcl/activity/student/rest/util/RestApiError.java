package com.tcl.activity.student.rest.util;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestApiError {

	protected HttpStatus status;
	
	protected String message;
	
	protected String stackTrace;
	
	protected String code;
	
	public RestApiError(HttpStatus status, String message) {
		
	}
	
}
