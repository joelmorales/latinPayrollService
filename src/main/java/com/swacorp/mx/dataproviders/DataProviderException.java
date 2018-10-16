package com.swacorp.mx.dataproviders;

import com.swacorp.mx.crosscutting.ApplicationException;

public class DataProviderException extends ApplicationException {

	public DataProviderException(String string, Exception ex) {
		super(string,ex);
	}

	public DataProviderException(String string) {
		super(string);
	}

}
