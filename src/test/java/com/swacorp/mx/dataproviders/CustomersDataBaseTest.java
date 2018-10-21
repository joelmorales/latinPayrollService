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
		when(customerTableDao.findOne(customerId)).thenReturn(new Customer());

		assertThatExceptionOfType(DataProviderException.class)
				.isThrownBy(() -> dataService.getCustomerAccount(customerId));
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
		givenDataRequestWithCorrectInformation();
		when(customerTableDao.save(any(Customer.class))).thenThrow(new IllegalArgumentException());

		assertThatExceptionOfType(DataProviderException.class).isThrownBy(() -> dataService.insertCustomer(request));

	}

	@Test
	public void when_dataService_Insert_Correct_EmployeePayment() {
		givenCorrectPayment();
		when(employeePaymentTableDAO.save(any(EmployeePayment.class))).thenReturn(employeePayment);
		CustomerPayment customerPayment = dataService.insertEmployeePayment(ID, payment);
		thenDAOReciveTheCorrectEmployeePayment();
		thenDataProviderReturnTheCorrectPayment(customerPayment);
	}

	@Test
	public void when_foundEmployeePayments_is_called() {
		givenEmployeePayments();
		when(employeePaymentTableDAO.findById(ID)).thenReturn(employeePayments);
		whenFindEmployeePaymentIsCalled();
		thenFindEmployeePaymentsReturnTheCorrectObjects();

	}

	private void thenFindEmployeePaymentsReturnTheCorrectObjects() {
		assertEquals(ONE_EMPLOYEE_PAYMENT, customerPayments.size());
		assertEquals(ID, customerPayments.get(0).getId());
		assertEquals(payment, customerPayments.get(0).getPayment(), 0);

	}

	private void whenFindEmployeePaymentIsCalled() {
		customerPayments = dataService.findEmployeePayments(ID);
	}

	private void givenEmployeePayments() {
		employeePayments = new ArrayList<>();
		givenCorrectPayment();
		employeePayments.add(employeePayment);
	}

	private void thenDAOReciveTheCorrectEmployeePayment() {
		ArgumentCaptor<EmployeePayment> captor = ArgumentCaptor.forClass(EmployeePayment.class);
		verify(employeePaymentTableDAO, times(1)).save(captor.capture());
		assertEquals(payment, captor.getValue().getPayment(), 0);
		assertEquals(ID, captor.getValue().getId());
		assertNotNull(captor.getValue().getPk());
	}

	private void thenDataProviderReturnTheCorrectPayment(CustomerPayment customerPayment) {
		assertEquals(ID, customerPayment.getId());
		assertEquals(payment, customerPayment.getPayment(), 0);
	}

	private void givenCorrectPayment() {
		employeePayment = new EmployeePayment();
		employeePayment.setId(ID);
		employeePayment.setPayment(payment);
		employeePayment.setPk(UUID.randomUUID().toString());
		employeePayment.setDate("20180-08-01");
	}

	private void thenCustomerWasInsertedCorrectly() {
		ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
		verify(customerTableDao, times(1)).save(captor.capture());

		Customer actual = captor.getValue();
		assertEquals(EMPLOYEE_TYPE, actual.getEmployeeType());
		assertEquals(ID, actual.getId());
		assertEquals(NAME, actual.getName());
		assertEquals(FREQUENCY, actual.getPayrollFrequency());
		assertEquals(RATE, actual.getRate(), 0);
	}

	private void whenDataServiceInsertCustomer() {
		customerAccount = dataService.insertCustomer(request);
	}

	private void WhenDaoIsCalledToSaveCustomer() {
		when(customerTableDao.save(any(Customer.class))).thenReturn(customer);
	}

	private void givenDataRequestWithCorrectInformation() {
		request = new DataRequest(ID, NAME, FREQUENCY, EMPLOYEE_TYPE, RATE);
	}

	private void thenGetCustomerAccountReturnCorrectObject() {
		assertEquals(customerAccount.getId(), ID);
		assertEquals(customerAccount.getName(), NAME);
		assertEquals(customerAccount.getRate(), RATE, 1);
		assertEquals(customerAccount.getFrequency(), FREQUENCY);
		assertEquals(customerAccount.getEmployeeType(), EMPLOYEE_TYPE);
	}

	private void whenGetAccountAccountIsCalled() {
		customerAccount = dataService.getCustomerAccount(customerId);
	}

	private void givenCustomerIsCorrect() {
		customer = new Customer();
		customer.setId(ID);
		customer.setName(NAME);
		customer.setPayrollFrequency(FREQUENCY);
		customer.setEmployeeType(EMPLOYEE_TYPE);
		customer.setRate(RATE);
	}

}
