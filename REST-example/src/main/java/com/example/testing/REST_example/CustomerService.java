package com.example.testing.REST_example;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getCustomerId());
        if (existingCustomer.isPresent()) {
            throw new IllegalArgumentException("Customer ID already exists");
        }
        return customerRepository.save(customer);
    }
}
