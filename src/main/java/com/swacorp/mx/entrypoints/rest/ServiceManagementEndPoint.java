package com.swacorp.mx.entrypoints.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swacorp.mx.crosscutting.ApplicationException;
import com.swacorp.mx.crosscutting.ServiceResponse;
import com.swacorp.mx.domain.Payroll;

@RestController
public class ServiceManagementEndPoint {

	//private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManagementEndPoint.class);
	public static final String API_PAY_PATH = "/start";
	public static final String API_MNT_PATH = "/setup";
	
	private Payroll payroll;

	public ServiceManagementEndPoint(Payroll payroll) {
		this.payroll = payroll;
	}

	/*@RequestMapping(value = "/test", method = RequestMethod.GET)	
	public @ResponseBody String startColdStart(@RequestParam String id) {
		LOGGER.info("Starting Coldstart Capabilities " );
		try {			
			return "TEST";
		} catch (Exception ex) {
			LOGGER.info("Failed: " + ex.getMessage());
			throw new NotStartingException(ex.getMessage());
		}
	}*/
	
	@RequestMapping(value = API_PAY_PATH, method = RequestMethod.GET)
	public @ResponseBody ServiceResponse sendPayroll(@RequestParam String id, @RequestParam Double hours ) {
		try {
			DataRequest data = getDataRequest(id, hours);
			return payroll.processClientPayment(data);
		} catch (Exception ex) {
			throw new ApplicationException("App",ex);
		}

	}

	@RequestMapping(value = API_MNT_PATH, method = RequestMethod.GET)
	public String CustomerMaintenance(@RequestParam String id, @RequestParam String name, @RequestParam String frq,
			@RequestParam String emptype) {
		return "GOOD";
	}
	
/*	private DataRequest getDataRequest(String id, String name, String frequencyTypes, String employeeTypes) {
		return new DataRequest(id, name, frequencyTypes, employeeTypes,100);
	}*/
	
	private DataRequest getDataRequest(String id, double hours) {
		return new DataRequest(id, hours);
	}

}
