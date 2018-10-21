package com.swacorp.mx.crosscutting;

public class ServiceResponse {

	private String id;
	private double payment;
	
	public ServiceResponse(String id, double payment) {
		this.id = id;
		this.payment = payment;
	}

	public String getId() {
		return id;
	}

	public double getPayment() {
		return payment;
	}
	
	

}
