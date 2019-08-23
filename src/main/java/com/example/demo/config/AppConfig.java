package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.controller.WelcomeController;
import com.example.demo.services.LoanEligibility;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class AppConfig {

	@Bean
	public LoanEligibility service() {
		return new LoanEligibility();
	}
	
	@Bean
	public WelcomeController controller() {
		
		return new WelcomeController();
	}
}
