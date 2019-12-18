package com.hcl.ecommerce.exception;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class ErrorResponse {
	
	public ErrorResponse() {
		super();
	}

	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

}
