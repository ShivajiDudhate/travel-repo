package com.travel.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.travel.pojo.Journey;

public interface JourneyRepo extends JpaRepository<Journey, Integer>{
	
    @Query("SELECT j FROM Journey j WHERE j.routeName =:routeName and j.customerId =:customerId")
	public List<Journey> noOfJoueryInLast48hr(@Param("routeName") String routeName, @Param("customerId") Integer customerId );

}
