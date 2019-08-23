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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.config.AppConfig;
import com.example.demo.controller.WelcomeController;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestWelcomeController {

	private MockMvc mockMvc;
	
		
	@Autowired
	private WelcomeController controller;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		//this.mockMvc = MockMvcBuilders.standaloneSetup(service).build();
	}
	
	@Test
	public void testGetMessage() throws Exception {
		
		this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
		.andExpect(content().string("Hello world"));
	}
	
	@Test
	public void testGetEligibility() throws Exception {

		this.mockMvc.perform(get("/check/{yearlyIncome}/{employment}",300000.00,"govt"))
		.andExpect(status().isOk())
				.andDo(print()).andExpect(content().string("600000.0"));
	
	}
}
