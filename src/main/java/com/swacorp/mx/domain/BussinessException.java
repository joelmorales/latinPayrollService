package com.swacorp.mx.domain;

import com.swacorp.mx.crosscutting.ApplicationException;

public class BussinessException extends ApplicationException {


	public BussinessException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BussinessException() {
		super();
	}

	public BussinessException(String string) {
		super(string);
	}

	private static final long serialVersionUID = 1L;

}
