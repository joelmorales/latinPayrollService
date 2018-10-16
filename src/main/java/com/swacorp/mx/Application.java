package com.swacorp.mx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = "com.swacorp.mx")
@ImportResource("classpath:spring/springConfiguration.xml")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
