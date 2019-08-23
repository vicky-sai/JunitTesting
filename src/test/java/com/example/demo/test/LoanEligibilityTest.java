package com.example.demo.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.config.AppConfig;
import com.example.demo.controller.WelcomeController;
import com.example.demo.services.LoanEligibility;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class LoanEligibilityTest {

	@Autowired
	private LoanEligibility service;
	
	@Test
	public void testCheckEligibilityForBusiness() throws Exception {
		
		double actual = service.checkEligibility(199999, "business");
		
		double expected = 500000.00;
		
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void testCheckEligibilityForFovtEmployees() throws Exception {
		
		double actual = service.checkEligibility(100000, "govt");
		
		double expected = 300000.00;
		
		assertEquals(expected, actual, 0);
	}
	
}
