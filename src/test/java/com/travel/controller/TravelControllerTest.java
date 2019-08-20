package com.travel.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.regex.Matcher;

import org.hamcrest.Matchers;
import org.hamcrest.collection.IsArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.travel.pojo.Customer;
import com.travel.pojo.Journey;
import com.travel.pojo.Route;
import com.travel.service.TravelSercice;

@RunWith(SpringJUnit4ClassRunner.class)
public class TravelControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private TravelSercice travelSercice;
	
	@InjectMocks
	private TravelController travelController;
	
	
	@Before
	public void setUp() throws Exception{
		
		mockMvc = MockMvcBuilders.standaloneSetup(travelController).build();
	}
	
	
	@Test
	public void addCustomerTest() throws Exception {
		String customer = "{\n"+ 
				            " \"customerName\":\"Shiavji\", \n" +
				            " \"customerType\":\"VIP\",  \n" +
				        " \"favRoute\":{\"name\" :\"pune-mumbai\", \n" +
			                     " \"satrtPoint\":\"pune\", \n" +
			                   " \"endPoint\":\"Mumbai\" } \n" +
	                           "}";
		
		Customer  customerobj = new Customer();
		
		doNothing().when(travelSercice).addCustomer(customerobj);
		
		mockMvc.perform(post("/customer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(customer)).andExpect(status().isOk());
	}
	
	
	@Test
	public void newJourneyTest() throws Exception {
		String journey = "{\n"+ 
				            " \"customerId\":\"1\", \n" +
				            " \"routeName\":\"pune-mumbai\" \n" +
	                           "}";
		
		Journey journeyobj = new Journey();
		
		doNothing().when(travelSercice).newJourney(journeyobj);
		
		mockMvc.perform(post("/journey")
				.contentType(MediaType.APPLICATION_JSON)
				.content(journey)).andExpect(status().isOk());
	}
	
	
	
}
