package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Payment;

@Service
public class PaymentService {

	private HashMap<Long, Payment> pmtList;
	
	public PaymentService() {
		this.pmtList = new HashMap<>();
		
		pmtList.put(100L, new Payment(100, "credit card payment", 4200));
		pmtList.put(101L, new Payment(101, "current bill payment", 8200));
	}
	
	public Payment addToList(Payment pmt) {

		Payment obj = this.pmtList.put(pmt.getPaymentId(), pmt); 
		
		return this.pmtList.get(pmt.getPaymentId());
		
	}
	
	public Payment findById(long id) {
		
		return this.pmtList.get(id);		
	}
	
	public List<Payment> findAll() {
		
		return this.pmtList.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());		
	}
	
	
}
