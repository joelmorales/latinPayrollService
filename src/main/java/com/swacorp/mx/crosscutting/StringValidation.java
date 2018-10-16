package com.swacorp.mx.crosscutting;

import java.util.Optional;

public class StringValidation {

	public static boolean isValid(String value){
		return Optional.ofNullable(value).filter(s -> !s.isEmpty()).isPresent();
	}
	
	public static boolean isInvalid(String value){
		return !isValid(value);
	}
	
}
