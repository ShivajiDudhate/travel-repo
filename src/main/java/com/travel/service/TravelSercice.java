package com.travel.service;

import javax.validation.Valid;

import com.travel.pojo.Customer;
import com.travel.pojo.Journey;

public interface TravelSercice {
	/**
	 * This method used to add new customer 
	 * @param customer
	 * @throws Exception
	 */
	void addCustomer(@Valid Customer customer) throws Exception;

	/**
	 * This method used to add new journey 
	 * @param journey
	 * @throws Exception
	 */
	void newJourney(@Valid Journey journey) throws Exception ;

}
