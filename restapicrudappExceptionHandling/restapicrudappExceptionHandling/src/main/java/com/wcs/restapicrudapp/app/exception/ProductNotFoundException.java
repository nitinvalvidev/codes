package com.wcs.restapicrudapp.app.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String msg) {
		super(msg);
		System.out.println("call");
	}

}
