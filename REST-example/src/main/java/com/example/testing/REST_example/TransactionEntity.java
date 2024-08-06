package com.example.testing.REST_example;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long transactionId;

    @Column(name = "TransactionDate", nullable = false)
    private LocalDate transactionDate;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = true) // Nullability set to true to handle ON DELETE SET NULL
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ProductCode", nullable = false)
    private ProductEntity product;

    @Column(name = "Quantity", nullable = false)
    private double quantity;

    // Getters and Setters

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

	public TransactionEntity(Long transactionId, LocalDate transactionDate, Customer customer, ProductEntity product,
			double quantity) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}
    
	public TransactionEntity() {

	}

	@Override
	public String toString() {
		return "TransactionEntity [transactionId=" + transactionId + ", transactionDate=" + transactionDate
				+ ", customer=" + customer + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
    
}
