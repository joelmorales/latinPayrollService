package com.swacorp.mx.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.swacorp.mx.domain.Payroll;
import com.swacorp.mx.entrypoints.rest.ServiceManagementEndPoint;

@Configuration
public class EndPointConfiguration {

	@Bean
	public ServiceManagementEndPoint serviceManagementEndPoint(Payroll payroll) {
		return new ServiceManagementEndPoint(payroll);
	}
	
	
	
}
