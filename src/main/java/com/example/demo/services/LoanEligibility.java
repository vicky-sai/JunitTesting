package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class LoanEligibility {

	public double checkEligibility(double yearlyIncome, String employment) {
		double allowedAmount = 100000.00;
		
		switch (employment) {
		case "business":
			if(yearlyIncome < 100000) {
				allowedAmount = 200000.00;
			} else {
				allowedAmount = 500000.00;
			}
			break;
		case "self":
			if(yearlyIncome < 200000) {
				allowedAmount = 300000.00;
			} else {
				allowedAmount = 700000.00;
			}
			break;
		case "govt":
			if(yearlyIncome < 200000) {
				allowedAmount = 300000.00;
			} else {
				allowedAmount = 700000.00;
			}
			break;
		default:
			break;
		}
		return allowedAmount;
	}
}
