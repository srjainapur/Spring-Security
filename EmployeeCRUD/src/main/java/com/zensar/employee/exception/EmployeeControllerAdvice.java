package com.zensar.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<Object> exception(EmployeeNotFoundException enfexp) {
		return new ResponseEntity<Object>("Employee Not Found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmployeeInsertException.class)
	public ResponseEntity<Object> insertException(EmployeeInsertException insertExp) {
		return new ResponseEntity<Object>("Exception Occured while inserting", HttpStatus.BAD_REQUEST);
	}
}
