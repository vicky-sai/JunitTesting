package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	
	@GetMapping("/get")
	public List<Payment> getAll() {
		return this.service.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Payment getPaymentById(@PathVariable("id") long id) {
		return this.service.findById(id);
	}
	
	@PostMapping(value="/add", produces = "application/json", consumes = "application/json") 
	public Payment addPayment(@RequestBody Payment pmt ) {
		return this.service.addToList(pmt);
	}
}
