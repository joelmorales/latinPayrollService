package com.swacorp.mx.dataproviders;

import com.swacorp.mx.crosscutting.ApplicationException;

public class DataProviderException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataProviderException(String string, Exception ex) {
		super(string,ex);
	}

	public DataProviderException(String string) {
		super(string);
	}

}
