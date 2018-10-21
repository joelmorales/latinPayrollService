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
//		payment=payroll.paymentRules(customerAccount, hours);
//		assertEquals(id,payrollresponse.getId());
//		assertEquals(payment,payrollresponse.getPayment(),0);
	}

	private void givenEmployeeTypeIsMonthly() {
		hours=160;
		hourlyRate = 16.55;
		request = getRequest();
		customerAccount=new CustomerAccount(id,hourlyRate,name,WEEKLY,Payroll.FULLTIME);
		when(dataService.getCustomerAccount(id)).thenReturn(customerAccount);
		
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
		customerAccount=getCustomerAccount();
		when(dataService.getCustomerAccount(id)).thenReturn(customerAccount);
	}

	private void whenPayrollCallProcessRequest() {
		//payrollresponse = payroll.processRequest(request);
	}

	private void thenPayrollReturnTheCustomerAccountReturnedByDataSource() {
		assertEquals(id,payrollresponse.getId());
	}

	private void thenGetCustomerAccountIsRetrieve() {
		verify(dataService, times(1)).getCustomerAccount(id);
	}

	private void whenPayrollProcessRequestIsCalled() {
		//payroll.processRequest(request);
	}
	

	private void then_HourlyEmployeePaymentByHourIsCorrect() {
//		payment=payroll.paymentRules(customerAccount, hours);
//		assertEquals(id,payrollresponse.getId());
//		assertEquals(payment,payrollresponse.getPayment(),0);
		
	}

	
	
	private void when_PayrollReceiveRequestForEmployeeType() {
//		payrollresponse = payroll.processRequest(request);
	}

	private void givenEmployeeTypeIsHourly() {
		hours=40;
		hourlyRate = 14.55;
		
		request = getRequest();
		customerAccount=getCustomerAccount();
		when(dataService.getCustomerAccount(id)).thenReturn(customerAccount);
	}

	private DataRequest getRequest() {
		return new DataRequest(id,name,hours);
	}

	private CustomerAccount getCustomerAccount() {
		return new CustomerAccount(id,hourlyRate,name,WEEKLY,Payroll.TEMPORARY);
	}

	
}
