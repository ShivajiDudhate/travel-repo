package com.travel.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travel.pojo.Customer;
import com.travel.pojo.Journey;
import com.travel.repo.CustomerRepo;
import com.travel.repo.JourneyRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelSerciceImplTest {
	
	@Autowired
	private TravelSercice travelSercice;
	
	@MockBean
	private CustomerRepo customerRepo;
	
	@MockBean
	private JourneyRepo journeyRepo;
	
	
	@Test
	public void addCustomerTest() throws Exception {
		
		Customer customer = new Customer();
		customer.setCustomerName("Raje");
		customer.setCustomerType("VIP");
		when(customerRepo.save(customer)).thenReturn(customer);
		
         travelSercice.addCustomer(customer);
		
		verify(customerRepo, times(1)).save(customer);
	}
	
	
	@Test
	public void addJourneyTest() throws Exception {
		
		Journey journey = new Journey();
		journey.setCustomerId(1);
		journey.setId(5);
		journey.setRouteName("pune-mumbai");
		when(journeyRepo.save(journey)).thenReturn(journey);
				
		travelSercice.newJourney(journey);
		
		verify(journeyRepo, times(1)).save(journey);
	}
	
}
