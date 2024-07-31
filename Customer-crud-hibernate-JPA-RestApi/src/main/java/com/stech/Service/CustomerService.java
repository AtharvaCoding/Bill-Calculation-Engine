package com.stech.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stech.Entity.Customer;
import com.stech.repository.CustomerRepository;



@Service
public class CustomerService {
	@Autowired
    private CustomerRepository repository;
  
    public Customer saveCustomer(Customer customer) {
        return repository.save(customer);
    }
  
    public List<Customer> saveCustomers(List<Customer> customers) {
        return repository.saveAll(customers);
    }
  
    public List<Customer> getCustomers() {
        return repository.findAll();
    }
  
    public Customer updateCustomer(Customer customer) {
    	Customer existingCustomer = repository.findById(customer.getCustId()).orElse(null);
        existingCustomer.setCustId(customer.getCustId());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setContact(customer.getContact());
        return repository.save(existingCustomer);
    }
}

