package com.stech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stech.Entity.Customer;
import com.stech.Service.CustomerService;

@RestController
public class CustomerController {
  
    @Autowired
    private CustomerService service;
  
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return service.saveCustomer(customer);
    }
  
    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customers) {
        return service.saveCustomers(customers);
    }
  
    @GetMapping("/Customers")
    public List<Customer> findAllCustomers() {
        return service.getCustomers();
    }
  
    @PutMapping("/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return service.updateCustomer(customer);
    }
}


