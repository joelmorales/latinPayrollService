package com.swacorp.mx.dataproviders;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.swacorp.mx.crosscutting.CustomerAccount;
import com.swacorp.mx.crosscutting.CustomerPayment;
import com.swacorp.mx.dataproviders.database.domain.Customer;
import com.swacorp.mx.dataproviders.database.domain.EmployeePayment;
import com.swacorp.mx.dataproviders.database.persistance.CustomerTableDAO;
import com.swacorp.mx.dataproviders.database.persistance.EmployeePaymentTableDAO;
import com.swacorp.mx.domain.AccountDataServices;
import com.swacorp.mx.entrypoints.rest.DataRequest;

public class DataProvider implements AccountDataServices {
	private CustomerTableDAO customerDao;
	private EmployeePaymentTableDAO employeePayment;

	public DataProvider(CustomerTableDAO customerTableDao, EmployeePaymentTableDAO employeePayment) {
		this.customerDao = customerTableDao;
		this.employeePayment = employeePayment;
	}

	@Override
	public CustomerAccount getCustomerAccount(final String id) {
		Customer customer = customerDao.findOne(id);
		if (customer.getId() == null) {
			throw new DataProviderException("Empty Customer");
		}
		return getCustomerAccount(customer);

	}

	@Override
	public CustomerAccount insertCustomer(DataRequest request) {
		Customer entity = getCustomer(request);
		try {
			Customer customer = customerDao.save(entity);
			return getCustomerAccount(customer);
		} catch (IllegalArgumentException e) {
			throw new DataProviderException("error tring to insert", e);
		}
	}

	private Customer getCustomer(DataRequest request) {
		Customer customer = new Customer();
		customer.setId(request.getId());
		customer.setName(request.getName());
		customer.setPayrollFrequency(request.getFrequencyTypes());
		customer.setRate(request.getRate());
		customer.setEmployeeType(request.getEmployeeTypes());
		return customer;
	}

	private CustomerAccount getCustomerAccount(Customer customer) {
		return new CustomerAccount(customer.getId(), customer.getRate(), customer.getName(),
				customer.getPayrollFrequency(), customer.getEmployeeType());
	}

	@Override
	public CustomerPayment insertEmployeePayment(String id, double payment) {
		EmployeePayment employeePayments = new EmployeePayment();
		employeePayments.setPk(UUID.randomUUID().toString());
		employeePayments.setId(id);
		employeePayments.setPayment(payment);
		EmployeePayment empPayment = employeePayment.save(employeePayments);
		return getCustomerPayment(empPayment);
	}

	private CustomerPayment getCustomerPayment(EmployeePayment employeePayment) {
		return new CustomerPayment(employeePayment.getId(), employeePayment.getDate(), employeePayment.getPayment());
	}

	@Override
	public List<CustomerPayment> findEmployeePayments(String id) {
		List<EmployeePayment> employeePayments = employeePayment.findById(id);
		return mapCustomerPaymentToEmploeePaments(employeePayments);
	}

	private List<CustomerPayment> mapCustomerPaymentToEmploeePaments(List<EmployeePayment> employeePayments) {
		List<CustomerPayment> customerPayments = new ArrayList<>();
		for (EmployeePayment employeePayment : employeePayments) {
			customerPayments.add(getCustomerPayment(employeePayment));
		}
		return customerPayments;

	}

}
