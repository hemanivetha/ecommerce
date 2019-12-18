package com.hcl.ecommerce.exception;

public class ProductNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(String exception) {
		super(exception);
	}

}
