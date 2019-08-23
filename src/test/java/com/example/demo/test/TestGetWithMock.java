package com.example.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.config.AppConfig;
import com.example.demo.controller.WelcomeController;
import com.example.demo.services.LoanEligibility;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestGetWithMock {

	private MockMvc mockMvc;
	
		
	@InjectMocks
	private WelcomeController controller;
	
	@Mock
	private LoanEligibility service;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		//this.mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}

	@Test
	public void testGetEligibility() throws Exception {
		
		when(service.checkEligibility(300000.00, "govt")).thenReturn(500000.0);
		
		this.mockMvc.perform(get("/check/{yearlyIncome}/{employment}",300000.00,"govt"))
		.andExpect(status().isOk())
				.andDo(print()).andExpect(content().string("500000.0"));
		
		//verify(service).checkEligibility(300000.00, "govt");
	}
}
