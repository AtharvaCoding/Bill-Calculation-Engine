package example.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Long transactionID;

    @Column(name = "TransactionDate", nullable = false)
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = true) // Ensure nullable = true to allow NULL values
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ProductCode", nullable = false)
    private Product product;

    @Column(name = "Quantity", nullable = false)
    private BigDecimal quantity;

	public Long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", transactionDate=" + transactionDate + ", customer="
				+ customer + ", product=" + product + ", quantity=" + quantity + "]";
	}

	public Transaction(Long transactionID, Date transactionDate, Customer customer, Product product,
			BigDecimal quantity) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}

    // Getters and Setters
}
