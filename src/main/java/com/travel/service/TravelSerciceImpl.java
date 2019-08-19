package com.travel.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.pojo.Customer;
import com.travel.pojo.Journey;
import com.travel.repo.CustomerRepo;
import com.travel.repo.JourneyRepo;

@Service
public class TravelSerciceImpl implements TravelSercice {
    @Autowired
    private CustomerRepo customerRepo;
    
    @Autowired
    private JourneyRepo journeyRepo;
    
    @Transactional
	@Override
	public void addCustomer(Customer customer) {
		customerRepo.save(customer);
	}
    
    
    @Transactional
	@Override
	public void newJourney(Journey journey) throws Exception {
    	LocalDate ldObj = LocalDate.now();
    	journey.setStartTime(ldObj);
    	
        BigDecimal journeyPrice = calculateJourenyPrice(journey);
        journey.setJurneyPrice(journeyPrice);
    	journeyRepo.save(journey);
		
	}
    
    
    /**
     * @param journey
     * @return
     * @throws Exception
     */
  
	private BigDecimal calculateJourenyPrice(Journey journey) throws Exception {
		
    	
         int noJourneyLastTwoDay = 0 ;
    	
      Float price = null;
    	 
    	Integer custIntegerId = journey.getCustomerId();
    	Optional<Customer> customer  = customerRepo.findById(custIntegerId);
    	     
        List<Journey> listOfjourneys = journeyRepo.noOfJoueryInLast48hr(journey.getRouteName(), custIntegerId);
    	
        for(Journey jour: listOfjourneys) {
        	
        	//Date tsp1  = jour.getStartTime(); 
        	//Date tsp  = journey.getStartTime();
        	
        	  LocalDate now = journey.getStartTime();
        	 LocalDate sixDaysBehind = jour.getStartTime();
        	 
        	 Period period = Period.between(now, sixDaysBehind);
        	 int diff = period.getDays();
        	
        	//Calendar myCal = Calendar.getInstance();
        	
        	//myCal.setTime(tsp1);
    
//        	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
//            Date firstDate = sdf.parse(tsp1.toString());
//            Date secondDate = sdf.parse(tsp.toString());
         
            //long diffInMillies = Math.abs(tsp.getTime() - tsp1.getTime());
           // int diff = (int) TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        	
        	 if ( diff < 2)
        	 {
        		 noJourneyLastTwoDay ++;
        	 }
        }
        
        String custType = null;
        String custFevRoute = null;
        if(customer.isPresent()) {
        	custType = customer.get().getCustomerType();
        	custFevRoute = customer.get().getFavRoute().getName();
          }else {
        	throw new Exception ("Customer not prenet in system with id::" + customer.get().getId());
          }
        
        
         if(custType.equalsIgnoreCase("VIP")) {
        	 price = 1f;
         }else{
        	 price = 2f;
         }
        
          
  
       
       if(!custType.equalsIgnoreCase("NonGrataCustomers") && custFevRoute.equals(journey.getRouteName())){
    	   price = (float) (price - (price * 0.3));
       }
       
       if(!custType.equalsIgnoreCase("NonGrataCustomers") && noJourneyLastTwoDay > 2){
    	   price = (float) (price - (price *0.1));
       }
         
    	return new BigDecimal(price);	
    }

}
