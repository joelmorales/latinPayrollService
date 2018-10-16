package com.swacorp.mx.crosscutting;

public class ApplicationException extends RuntimeException  {

	public ApplicationException(String message, Throwable cause) {
		super(message,cause);
	}

	public ApplicationException() {
		super();
	}

	
	public ApplicationException(String string) {
		super(string);
	}


	private static final long serialVersionUID = 1L;
	

}
