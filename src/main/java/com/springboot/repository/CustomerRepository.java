package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Customer;

public interface CustomerRepository 
                extends JpaRepository<Customer, Integer>{

    
}
