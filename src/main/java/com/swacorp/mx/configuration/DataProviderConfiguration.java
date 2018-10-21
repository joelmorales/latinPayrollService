package com.swacorp.mx.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swacorp.mx.dataproviders.CustomersDataBase;
import com.swacorp.mx.dataproviders.database.persistance.CustomerTableDAO;
import com.swacorp.mx.dataproviders.database.persistance.EmployeePaymentTableDAO;

@Configuration
public class DataProviderConfiguration {

	@Bean
	public CustomersDataBase dataProvider(CustomerTableDAO customerTableDao, EmployeePaymentTableDAO employedDao) {
		return new CustomersDataBase(customerTableDao,employedDao);
	}
	
	
}
