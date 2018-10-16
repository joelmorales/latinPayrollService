package com.swacorp.mx.domain;

import java.util.List;

import com.swacorp.mx.crosscutting.CustomerAccount;
import com.swacorp.mx.crosscutting.CustomerPayment;
import com.swacorp.mx.entrypoints.rest.DataRequest;

public interface AccountDataServices {

	CustomerAccount getCustomerAccount(String request);
	CustomerAccount insertCustomer(DataRequest request);
	CustomerPayment insertEmployeePayment(String id, double payment);
	List<CustomerPayment> findEmployeePayments(String id);
}