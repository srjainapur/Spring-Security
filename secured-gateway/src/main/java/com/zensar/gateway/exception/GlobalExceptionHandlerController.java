package com.zensar.gateway.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> handleCustomException(HttpServletResponse res, CustomException ce) throws IOException {
		LOG.error("ERROR", ce);
		//res.sendError(ce.getHttpStatus().value(), ce.getMessage());
		return new ResponseEntity<Object>(ce.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> handleAccessDeniedException(HttpServletResponse res, AccessDeniedException e) throws IOException {
		LOG.error("ERROR", e);
		//res.sendError(HttpStatus.FORBIDDEN.value(), "Access denied");
		return new ResponseEntity<Object>("Access denied", HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(HttpServletResponse res, IllegalArgumentException e) throws IOException {
		LOG.error("ERROR", e);
		//res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
		return new ResponseEntity<Object>("Something went wrong", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletResponse res, Exception e) throws IOException {
		LOG.error("ERROR", e);
		//res.sendError(HttpStatus.BAD_REQUEST.value(), "Something went wrong");
		return new ResponseEntity<Object>("Something went wrong", HttpStatus.BAD_REQUEST);
	}
}
