package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.LoanEligibility;

@RestController
public class WelcomeController {

	@Autowired
	private LoanEligibility service;
	
	@GetMapping("/hello")
	public String getMessage() {
		
		return "Hello world";
	}
	
	@GetMapping("/check/{yearlyIncome}/{employment}") 
	public double getEligibility(@PathVariable("yearlyIncome") double yearlyIncome,
			@PathVariable("employment") String employment)	{
		
		return this.service.checkEligibility(yearlyIncome, employment);
	}
}
