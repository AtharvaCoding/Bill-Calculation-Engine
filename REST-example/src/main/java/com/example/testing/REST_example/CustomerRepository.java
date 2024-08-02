package com.example.testing.REST_example;



//import com.example.testing.REST_example.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
}
