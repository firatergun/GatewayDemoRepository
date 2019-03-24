package com.firatergun.gatewaydemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestExceptionHandler {

	@ResponseBody
	@ExceptionHandler(TransactionNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String TransactionNotFound(TransactionNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(PageRequestOutOfBoundsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String PageNumberOutOfBounds(PageRequestOutOfBoundsException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(ClientNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String ClientNotFound(ClientNotFoundException ex) {
		return ex.getMessage();
	}
}
