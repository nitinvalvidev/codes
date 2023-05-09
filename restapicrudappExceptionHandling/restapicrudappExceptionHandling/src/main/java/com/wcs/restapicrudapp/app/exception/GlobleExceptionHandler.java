package com.wcs.restapicrudapp.app.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // handle globle exception
public class GlobleExceptionHandler {
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String productNotFoundExceptionHandler(ProductNotFoundException e) {
		System.out.println("exception handler method call");
		return e.getMessage();
	}
	@ExceptionHandler(ArithmeticException.class)
	public String ArithmeticExceptionHandler(ArithmeticException e) {
		System.out.println("exception handler method call");
		return e.getMessage();
	}

}
