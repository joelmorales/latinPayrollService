package com.swacorp.mx.crosscutting;

public class CustomerPayment {
	
	private String id;
	private String date;
	private double payment;
	
	public CustomerPayment(String id, String date, double payment) {
		this.id = id;
		this.date = date;
		this.payment = payment;
	}
	
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public double getPayment() {
		return payment;
	}
	

}
