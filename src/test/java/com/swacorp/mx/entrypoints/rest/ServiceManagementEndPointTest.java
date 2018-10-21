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
		request = new DataRequest(ID, NAME, FREQUENCY, EMPLOYEE_TYPE,10);
	}

	//@Test
	public void when_serviceManagement_receive_a_request_is_SendTo_Domain() {

		whenServiceManagementRecieveRequest();
		thenLatinPayrollDomainReceiveTheRequest();
	}

	//@Test
	public void when_ServiceManagment_receieve_response_status_from_Domain() {
		payrollProcessRequestReturnStatusOK();
		String status = whenServiceManagermentSendPayroll();
		thenPayrollProcessRequestResponseWithOkStatus(status);
	}

	//@Test
	public void when_receiveBadParameter_ApplicationExceptionIsRaised() {
		assertThatExceptionOfType(ApplicationException.class)
		.isThrownBy(() -> payroll.processRequest(any(DataRequest.class)));
	}
	
	private void thenPayrollProcessRequestResponseWithOkStatus(String status) {
		assertEquals(STATUS_OK, status);
	}

	private String whenServiceManagermentSendPayroll() {
		//String status = service.sendPayroll(ID, NAME, hours);
		//return status;
		return null;
	}

	private void payrollProcessRequestReturnStatusOK() {
		//when(payroll.processRequest(any(DataRequest.class))).thenReturn(STATUS_OK);
	}

	private void whenServiceManagementRecieveRequest() {
		//service.sendPayroll(ID, NAME, hours);
	}

	private void thenLatinPayrollDomainReceiveTheRequest() {

		//verify(payroll, times(1)).processRequest(any(DataRequest.class));
		
		ArgumentCaptor<DataRequest> captor = ArgumentCaptor.forClass(DataRequest.class);
		verify(payroll, times(1)).processRequest(captor.capture());

		DataRequest actual = captor.getValue();
		assertEquals(FREQUENCY, actual.getFrequencyTypes());
		assertEquals(ID, actual.getId());
		assertEquals(NAME, actual.getName());
		assertEquals(EMPLOYEE_TYPE, actual.getEmployeeTypes());
	}

}
