package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.services.LoanEligibility;

@SpringBootApplication
public class JunitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitTestingApplication.class, args);
	}

}
