package com.swacorp.mx.entrypoints.rest;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.swacorp.mx.crosscutting.ApplicationException;
import com.swacorp.mx.domain.Payroll;


public class ServiceManagementEndPointTest {

	private static final String EMPLOYEE_TYPE = "emptype";
	private static final String FREQUENCY = "frq";
	private static final String NAME = "name";
	private static final String ID = "id";
	private  static final double hours =45;
	private static final String STATUS_OK = "OK";
	private Payroll payroll = mock(Payroll.class);
	private ServiceManagementEndPoint service = new ServiceManagementEndPoint(payroll);
	private String clientObject = "TEST";
	private DataRequest request;

	@Before
	public void setUp() {
		
	}

	//@Test
	public void when_serviceManagement_receive_a_request_is_SendTo_Domain() {

		whenServiceManagementRecieveRequest();
		thenLatinPayrollDomainReceiveTheRequest();
	}

	//@Test
	public void when_ServiceManagment_receieve_response_status_from_Domain() {
		
	}

	//@Test
	public void when_receiveBadParameter_ApplicationExceptionIsRaised() {
		//assertThatExceptionOfType(ApplicationException.class)
		//.isThrownBy(() -> payroll.processRequest(any(DataRequest.class)));
	}
	
	private void thenPayrollProcessRequestResponseWithOkStatus(String status) {
		
	}

	private String whenServiceManagermentSendPayroll() {
		
		return null;
	}

	private void payrollProcessRequestReturnStatusOK() {
		
	}

	private void whenServiceManagementRecieveRequest() {
		
	}

	private void thenLatinPayrollDomainReceiveTheRequest() {

		//ArgumentCaptor<DataRequest> captor = ArgumentCaptor.forClass(DataRequest.class);
		//verify(payroll, times(1)).processRequest(captor.capture());

		//DataRequest actual = captor.getValue();
		
	}

}
