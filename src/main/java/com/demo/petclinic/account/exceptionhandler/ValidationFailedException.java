package com.demo.petclinic.account.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationFailedException extends RuntimeException {

	public ValidationFailedException(String exception) {
		super(exception);
	}

}
