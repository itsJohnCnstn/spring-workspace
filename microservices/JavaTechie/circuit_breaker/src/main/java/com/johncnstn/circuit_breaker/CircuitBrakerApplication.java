package com.johncnstn.circuit_breaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CircuitBrakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBrakerApplication.class, args);
	}

}
