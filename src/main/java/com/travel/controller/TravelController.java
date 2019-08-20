package com.travel.controller;

import javax.validation.Valid;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.pojo.Customer;
import com.travel.pojo.Journey;
import com.travel.service.TravelSercice;

@RestController
public class TravelController {
	
	@Autowired
	private TravelSercice travelSercice;
	
	/**
	 * @param customer
	 * @return
	 */
	@PostMapping(value = "/customer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) {
		try {
			travelSercice.addCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<>("Not able to add New Customer :::"+e.getMessage(),HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>("Customer added successfully",HttpStatus.OK);
	}
	
	
	/**
	 * @param journey
	 * @return
	 */
	@PostMapping(value ="/journey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<String> newJourney(@Valid @RequestBody Journey journey) {
		try {
			travelSercice.newJourney(journey);
		} catch (Exception e) {
			return new ResponseEntity<>("Not able to add New Journey :::"+e.getMessage(), 
					HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>("Journey added successfully",HttpStatus.OK);
	}
	
	

}
