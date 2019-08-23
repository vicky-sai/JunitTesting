package com.example.demo.test;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.config.AppConfig;
import com.example.demo.controller.PaymentController;
import com.example.demo.model.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestPaymentController {

	private MockMvc mock;
	
	@Autowired
	private PaymentController controller;
	
	@Before
	public void setUp() throws Exception{
		this.mock = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
//	@Test
//	public void testGetAll() throws Exception {
//		this.mock.perform(get("/payment/get").contentType(MediaType.APPLICATION_JSON))
//        .andExpect(status().isOk())
//				.andDo(print())
//				.andExpect(jsonPath("$.*", Matchers.hasSize(2) ));
//	}
//	
//	@Test
//	public void testGetById() throws Exception {
//		this.mock.perform(get("/payment/get/{id}", 101)
//				.contentType(MediaType.APPLICATION_JSON))
//        		.andExpect(status().isOk())
//				.andDo(print())
//				.andExpect(jsonPath("$.paymentId", Matchers.is(101) ))
//				.andExpect(jsonPath("$.description", Matchers.is("current bill payment")))
//				.andExpect(jsonPath("$.amount", Matchers.is(8200.0) ));
//	}
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);			
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
	}
	
	@Test
	public void testInsert() throws Exception {
		
		Payment mockCourse = new Payment(204, "cabpayment", 6500);
		
		String expected = "{paymentId: 204, description: cabpayment, amount:6500}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/payment/add")
				.accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(mockCourse))
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mock.perform(requestBuilder).andDo(print()).andReturn();
		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(),false);
//		assertEquals(expected, result);
		
	}
}
