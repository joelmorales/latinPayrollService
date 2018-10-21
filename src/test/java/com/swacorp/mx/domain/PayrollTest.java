package com.swacorp.mx.domain;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import com.swacorp.mx.crosscutting.CustomerAccount;
import com.swacorp.mx.crosscutting.ServiceResponse;
import com.swacorp.mx.dataproviders.CustomersDataBase;
import com.swacorp.mx.entrypoints.rest.DataRequest;

public class PayrollTest {
	

	private static final String WEEKLY = "WEEKLY";
	private DataRequest request = null;
	private CustomersDataBase dataService = mock(CustomersDataBase.class);
	private Payroll payroll = new Payroll(dataService);
	private CustomerAccount customerAccount ;
	private String id="10078";
	private String name="Juan Miguel";
	private double hours;
	private double hourlyRate;
	private ServiceResponse payrollresponse;
	private double payment;
	
	@Test
	public void when_Payroll_Service_Sent_Request_to_DataServices() {

		request = getRequest();
		givenCorrectCustomerAccount();
		whenPayrollProcessRequestIsCalled();
		thenGetCustomerAccountIsRetrieve();
	}
	
	@Test
	public void when_Payroll_recive_customerAccount() {
		request = getRequest();
		givenCorrectCustomerAccount();
		whenPayrollCallProcessRequest();
		thenPayrollReturnTheCustomerAccountReturnedByDataSource();
	}

	@Test
	public void when_EmployeeType_IsHourly_Then_PaymentRulesPaid_ByHour() {
		givenEmployeeTypeIsHourly();
		when_PayrollReceiveRequestForEmployeeType();
		then_HourlyEmployeePaymentByHourIsCorrect();
	}
	
	@Test
	public void when_EmployeeType_IsMonthly_Then_PaymentRulesPaid_InFull() {
		givenEmployeeTypeIsMonthly();
		when_PayrollReceiveRequestForEmployeeType();
		then_MonthlyEmployeePaymentByHourIsCorrect();
	}
	
	private void then_MonthlyEmployeePaymentByHourIsCorrect() {
		
	}

	private void givenEmployeeTypeIsMonthly() {
		
		
	}

	@Test
	public void when_EmployeeType_IsContractor_Then_paymentRulesPaid_ByHour() {
		
	}
	
	@Test
	public void when_EmployeeType_IsFullTime_Then_OvertimeRules_IsDouble() {
		
	}
	
	@Test
	public void when_EmployeeType_IsHourle_Then_OvertimeRules_IsOneAndHalf() {
		
	}
	
	
	private void givenCorrectCustomerAccount() {
		
	}

	private void whenPayrollCallProcessRequest() {
		
	}

	private void thenPayrollReturnTheCustomerAccountReturnedByDataSource() {
		
	}

	private void thenGetCustomerAccountIsRetrieve() {
		
	}

	private void whenPayrollProcessRequestIsCalled() {
		
	}
	

	private void then_HourlyEmployeePaymentByHourIsCorrect() {
		
	}

	
	
	private void when_PayrollReceiveRequestForEmployeeType() {
		
	}

	private void givenEmployeeTypeIsHourly() {
		
	}

	private DataRequest getRequest() {
		return new DataRequest(id,name,hours);
	}

	private CustomerAccount getCustomerAccount() {
		return new CustomerAccount(id,hourlyRate,name,WEEKLY,Payroll.TEMPORARY);
	}

	
}
