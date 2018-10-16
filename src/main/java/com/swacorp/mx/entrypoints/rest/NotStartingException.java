package com.swacorp.mx.entrypoints.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.swacorp.mx.crosscutting.ApplicationException;

@ResponseStatus(HttpStatus.CONFLICT)
public class NotStartingException extends ApplicationException  {

	public NotStartingException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

	
	
}
