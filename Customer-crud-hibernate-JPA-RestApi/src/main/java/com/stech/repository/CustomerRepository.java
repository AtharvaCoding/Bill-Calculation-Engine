package com.stech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stech.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
		 
}
