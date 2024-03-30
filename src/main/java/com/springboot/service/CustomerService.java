package com.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.model.Customer;
import com.springboot.repository.CustomerRepository;

@Service
public class CustomerService {
    
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;

    }

    public List<Customer> getCustomers(){

        return customerRepository.findAll();

    }

    public Optional<Customer> getCustomerById(Integer id){

        return customerRepository.findById(id);

    }

    public void addCustomer(Customer customer){

        customerRepository.save(customer);

    }

    public void deleteCustomer(Integer id){

        customerRepository.deleteById(id);

    }
    
    public void updateCustomer(Customer customer){

        customerRepository.save(customer);

    }

}
