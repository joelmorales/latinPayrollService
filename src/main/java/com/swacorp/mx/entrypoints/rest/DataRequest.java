package com.swacorp.mx.entrypoints.rest;

public class DataRequest {

	private String id;
	private String name;
	private String frequencyTypes;
	private String employeeTypes;
	private double rate;
	private double hours;
	
	public DataRequest(String id, String name, String frequencyTypes, String employeeTypes,double rate) {
		this.id = id;
		this.name = name;
		this.frequencyTypes = frequencyTypes;
		this.employeeTypes = employeeTypes;
		this.rate = rate;
	}


	
	public DataRequest(String id,double hours) {
		this.id = id;		
		this.hours = hours;
	}
	
	public DataRequest(String id, String name, double hours) {
		this.id = id;		
		this.hours = hours;
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFrequencyTypes() {
		return frequencyTypes;
	}

	public String getEmployeeTypes() {
		return employeeTypes;
	}

	public double getRate() {
		return rate;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}
	
	
	
}
