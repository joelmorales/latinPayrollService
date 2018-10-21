package com.swacorp.mx.dataproviders;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.swacorp.mx.crosscutting.CustomerAccount;
import com.swacorp.mx.crosscutting.CustomerPayment;
import com.swacorp.mx.dataproviders.database.domain.Customer;
import com.swacorp.mx.dataproviders.database.domain.EmployeePayment;
import com.swacorp.mx.dataproviders.database.persistance.CustomerTableDAO;
import com.swacorp.mx.dataproviders.database.persistance.EmployeePaymentTableDAO;
import com.swacorp.mx.domain.AccountDataServices;
import com.swacorp.mx.entrypoints.rest.DataRequest;

public class CustomersDataBaseTest {

	private CustomerTableDAO customerTableDao = mock(CustomerTableDAO.class);
	private EmployeePaymentTableDAO employeePaymentTableDAO = mock(EmployeePaymentTableDAO.class);
	private AccountDataServices dataService = new CustomersDataBase(customerTableDao, employeePaymentTableDAO);
	private String customerId = "1111";
	private String ID = "111";
	private double RATE = 10;
	private String EMPLOYEE_TYPE = "type";
	private String NAME = "Joel";
	private String FREQUENCY = "weekly";
	private Customer customer;
	private CustomerAccount customerAccount;
	private DataRequest request;
	private double payment = 500;
	private EmployeePayment employeePayment;
	private List<EmployeePayment> employeePayments;
	private int ONE_EMPLOYEE_PAYMENT = 1;
	private List<CustomerPayment> customerPayments;

	// @Test
	public void when_dataService_send_then_return_the_customerAccount() {
		// String customerAccount = dataService.getCustomerAccount(request);
		// assertEquals(request, customerAccount);
	}

	@Test
	public void when_dataService_send_the_request_then_return_One_CustomersAccount() {
		givenCustomerIsCorrect();
		when(customerTableDao.findOne(customerId)).thenReturn(customer);
		whenGetAccountAccountIsCalled();
		thenGetCustomerAccountReturnCorrectObject();

	}

	@Test
	public void when_customerDataDAO_return_empty_object_then_dataProviderException_is_raise() {
		
		//assertThatExceptionOfType(DataProviderException.class)
		//		.isThrownBy(() -> dataService.getCustomerAccount(customerId));
	}

	@Test
	public void when_dataService_insert_Customer_with_CorrectInformation() {
		givenDataRequestWithCorrectInformation();
		givenCustomerIsCorrect();
		WhenDaoIsCalledToSaveCustomer();
		whenDataServiceInsertCustomer();
		thenGetCustomerAccountReturnCorrectObject();
		thenCustomerWasInsertedCorrectly();
	}

	@Test
	public void when_customerTableDao_throwAException_then_dataProviderException_is_raise() {
	
	}

	@Test
	public void when_dataService_Insert_Correct_EmployeePayment() {
		
	}

	@Test
	public void when_foundEmployeePayments_is_called() {
		

	}

	private void thenFindEmployeePaymentsReturnTheCorrectObjects() {
		
	}

	private void whenFindEmployeePaymentIsCalled() {
		
	}

	private void givenEmployeePayments() {
		
	}

	private void thenDAOReciveTheCorrectEmployeePayment() {
		//ArgumentCaptor<EmployeePayment> captor = ArgumentCaptor.forClass(EmployeePayment.class);
		//verify(employeePaymentTableDAO, times(1)).save(captor.capture());
		
	}

	private void thenDataProviderReturnTheCorrectPayment(CustomerPayment customerPayment) {
	
	}

	private void givenCorrectPayment() {
		
	}

	private void thenCustomerWasInsertedCorrectly() {
		//ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
		//verify(customerTableDao, times(1)).save(captor.capture());

		//Customer actual = captor.getValue();
		
	}

	private void whenDataServiceInsertCustomer() {
		
	}

	private void WhenDaoIsCalledToSaveCustomer() {
		
	}

	private void givenDataRequestWithCorrectInformation() {
		
	}

	private void thenGetCustomerAccountReturnCorrectObject() {
		
	}

	private void whenGetAccountAccountIsCalled() {
		
	}

	private void givenCustomerIsCorrect() {
		
	}

}
