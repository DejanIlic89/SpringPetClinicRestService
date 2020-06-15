package com.comtrade.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException(Exception exception) {
		EntityErrorResponse entityErrorResponse = new EntityErrorResponse();
		entityErrorResponse.setId(HttpStatus.BAD_REQUEST.value());
		entityErrorResponse.setPoruka(exception.getMessage());
		entityErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<EntityErrorResponse>(entityErrorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException404(EntityNotFoundException exception) {
		EntityErrorResponse entityErrorResponse = new EntityErrorResponse();
		entityErrorResponse.setId(HttpStatus.NOT_FOUND.value());
		entityErrorResponse.setPoruka(exception.getMessage());
		entityErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<EntityErrorResponse>(entityErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleException500(EntityServerErrorException exception) {
		EntityErrorResponse entityErrorResponse = new EntityErrorResponse();
		entityErrorResponse.setId(HttpStatus.INTERNAL_SERVER_ERROR.value());
		entityErrorResponse.setPoruka(exception.getMessage());
		entityErrorResponse.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<EntityErrorResponse>(entityErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
