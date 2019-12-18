package com.hcl.ecommerce.exception;

public class NoOrderFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoOrderFoundException(String exception) {
		super(exception);
	}

}
