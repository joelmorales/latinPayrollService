package com.swacorp.mx.integrationtest.database;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.swacorp.mx.crosscutting.CustomerAccount;
import com.swacorp.mx.crosscutting.CustomerPayment;
import com.swacorp.mx.dataproviders.CustomersDataBase;
import com.swacorp.mx.dataproviders.database.persistance.CustomerTableDAO;
import com.swacorp.mx.dataproviders.database.persistance.EmployeePaymentTableDAO;
import com.swacorp.mx.entrypoints.rest.DataRequest;

@RunWith(SpringRunner.class)
@DataJpaTest

public class DataProviderIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataProviderIntegrationTest.class);

	@Autowired
	CustomersDataBase dataProvider;

	@Autowired
	CustomerTableDAO customerTableDAO;

	@Autowired
	EmployeePaymentTableDAO employeePayment;

	private DataRequest datarequest;

	private String employeeType = "employeeType";

	private String id = "1000";

	private String name = "JUAN";

	private String payrollFrequency = "payrollFrequency";

	private double rate = 8.65;

	private CustomerAccount customerAccount;

	private double payment;

	private CustomerPayment customerPayment;

	private List<CustomerPayment> customerPayments;

	@Before
	public void setUp() {
		customerTableDAO.deleteAll();
		employeePayment.deleteAll();
	}

	@Test
	public void when_InsertOne_Customer_Return_The_Customer() {
		giveWeHaveACorrectCustomer();
		whenClientInsertACustomer();
		thenTheCorrectCustomerWasStored();
	}

	@Test
	public void when_insertOnePayment_return_the_payment() {
		givenWeHaveACorrectPayment();
		givenSystemInsertCustomerPayment();
		thenTheCorrectPaymentWasStored();
	}

	@Test
	public void when_Client_Request_Customer_payment() {
		givenSystemInsertCustomerPayment();
		whenClientRequestCustomerPayment();
		thenCustomerPaymentsWereFound();
		thenTheCorrectPaymentWasStored();
	}

	private void thenTheCorrectPaymentWasStored() {
		

	}

	private void givenSystemInsertCustomerPayment() {
		
	}

	private void givenWeHaveACorrectPayment() {
		
	}

	private void thenTheCorrectCustomerWasStored() {
		
	}

	// Validate Exception with wrong data
	// Find the wrong customer
	// Find payment Data

	private void whenClientInsertACustomer() {
		

	}

	private void giveWeHaveACorrectCustomer() {
		

	}

	private void whenClientRequestCustomerPayment() {
		
	}

	private void thenCustomerPaymentsWereFound() {
		
	}

}
