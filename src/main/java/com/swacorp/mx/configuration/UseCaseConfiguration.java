package com.swacorp.mx.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swacorp.mx.domain.AccountDataServices;
import com.swacorp.mx.domain.Payroll;

@Configuration
public class UseCaseConfiguration {

	@Bean
	public Payroll payroll(AccountDataServices dataService) {
		return new Payroll(dataService);
	}
	
}
