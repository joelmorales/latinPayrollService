package com.swacorp.mx.domain;

import com.swacorp.mx.crosscutting.CustomerAccount;
import com.swacorp.mx.crosscutting.ServiceResponse;
import com.swacorp.mx.entrypoints.rest.DataRequest;

public class Payroll {

	protected static final String FULLTIME = "FULLTIME";
	protected static final String TEMPORARY = "TEMPORARY";
	
	private AccountDataServices dataService;

	public Payroll(AccountDataServices dataService) {
		this.dataService = dataService;
	}

	public ServiceResponse processClientPayment(DataRequest dataRequest) {
		CustomerAccount customerAccount=dataService.getCustomerAccount(dataRequest.getId());
		double payment = getPayment(customerAccount,dataRequest.getHours());
		
		return getResponse(dataRequest.getId(),payment);

	}

	private ServiceResponse getResponse(String id,double payment) {
		ServiceResponse payrollResponse = new ServiceResponse(id,payment);
		return payrollResponse;
	}
	
	protected double getPayment(CustomerAccount customerAccount,double hours) {
		double payment=0.0;
		if(customerAccount.getEmployeeType().equals(TEMPORARY)) {
			payment=customerAccount.getRate()*hours;
		}else if(customerAccount.getEmployeeType().equals(FULLTIME)) {
			payment=customerAccount.getRate()*hours;
		}
		else
			throw new BussinessException("Bad Type");
		
		return payment;
	}
	
}
