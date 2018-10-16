package com.swacorp.mx.crosscutting;

public class PayrollResponse {

	private String id;
	private double payment;
	
	public PayrollResponse(String id, double payment) {
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
