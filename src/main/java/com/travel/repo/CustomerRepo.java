package com.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.pojo.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer>{

}
