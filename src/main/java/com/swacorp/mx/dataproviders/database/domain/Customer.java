package com.swacorp.mx.dataproviders.database.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	private String id;

	@Column(name = "Name", length = 20)
	public String name;

	@Column(name = "PayrollFrequency", length = 12)
	public String payrollFrequency;

	@Column(name = "EmployeeType", length = 20)
	public String employeeType;

	@Column(name = "Rate", length = 12)
	public double rate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPayrollFrequency() {
		return payrollFrequency;
	}

	public void setPayrollFrequency(String payrollFrequency) {
		this.payrollFrequency = payrollFrequency;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
}
