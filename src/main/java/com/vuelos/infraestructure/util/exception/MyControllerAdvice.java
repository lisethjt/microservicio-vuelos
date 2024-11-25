package com.vuelos.infraestructure.util.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(FlightException.class)
	public ResponseEntity<String> handleEmptyInput(FlightException emptyInputException) {
		return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
	}
}