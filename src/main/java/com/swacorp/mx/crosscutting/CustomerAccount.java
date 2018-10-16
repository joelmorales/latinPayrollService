package com.swacorp.mx.crosscutting;

public class CustomerAccount {
	private String id;
	private double rate;
	private String name;
	private String frequency;
	private String employeeType;

	public CustomerAccount(String id, double rate, String name, String frequency, String employeeType) {
		this.id = id;
		this.rate = rate;
		this.name = name;
		this.frequency = frequency;
		this.employeeType = employeeType;
	}

	public String getId() {
		return id;
	}

	public double getRate() {
		return rate;
	}

	public String getName() {
		return name;
	}

	public String getFrequency() {
		return frequency;
	}

	public String getEmployeeType() {
		return employeeType;
	}

}
