package com.stech.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Customer")
public class Customer {
 
     
    @Id
    @GeneratedValue
    private int custId;
      
    @Column(name="Name")
    private String Name;
      
    @Column(name="Contact")
    private String Contact;
    
    @Column(name="Address")
    private String Address;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", Name=" + Name + ", Contact=" + Contact + ", Address=" + Address + "]";
	}
    
    
}
