package com.springboot.Control;

import java.util.List;

import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entidades.Customer;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){

        this.customerRepository = customerRepository;

    }


    @GetMapping
    public List<Customer> getCustomers(){

        return customerRepository.findAll();

    }


    public record NewCustomerRequest(

        String name,
        String email,
        Integer age

    ) {
    }

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){

        Customer customer = new Customer();

        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);

        customerRepository.save(customer);

    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){

        customerRepository.deleteById(id);

    }
    
    @PutMapping("{customerId}")
    public void updateCustomer( @PathVariable("customerId") Integer id, 
                                @RequestBody NewCustomerRequest request){

        Optional<Customer> OptionalCustomer = customerRepository.findById(id);

        Customer customer = OptionalCustomer.get();

        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);

        customerRepository.save(customer);


    }
}
