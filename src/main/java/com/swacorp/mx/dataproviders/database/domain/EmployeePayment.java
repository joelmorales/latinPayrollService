package com.swacorp.mx.dataproviders.database.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeePayments")
public class EmployeePayment {

	
	@Id
	@Column(name="PK", unique = true, nullable=false)
	private String pk;
	
	@Column(name = "ID", nullable = false)
	private String id;
	
	@Column(name = "Date", length = 20)
	public String date;
	
	@Column(name = "Payment", length = 20)
	public double payment;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}
	
	
	
	
}
