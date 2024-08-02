package com.example.testing.REST_example;



import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")

public class Customer {
//	@Id
////	@GeneratedValue(strategy = GenerationType.IDENTITY) // Use AUTO for MySQL or IDENTITY for Oracle
//    @Column(name = "CustomerID")
	
	@Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
//    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
	
//	fdsafdsa
    @Column(name = "CustomerID")
    private Long customerId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Contact")
    private String contact;
    
    
	
	public Customer(long l, String name, String address, String contact) {
		super();
		this.customerId = l;
		this.name = name;
		this.address = address;
		this.contact = contact;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", contact=" + contact
				+ "]";
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}

}

