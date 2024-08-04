package com.example.testing.REST_example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "Product")
public class ProductEntity {

    @Id
    @Column(name = "ProductCode")
    private String productCode;
    
	@Column(name = "ProductName", nullable = false) 
    private String productName;

    @Column(name = "UnitPrice", nullable = false)
    private double unitPrice;

    public ProductEntity(String productCode, String productName, double unitPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.unitPrice = unitPrice;
	}
    
    public ProductEntity() {

	}

	@Override
	public String toString() {
		return "ProductEntity [productCode=" + productCode + ", productName=" + productName + ", unitPrice=" + unitPrice
				+ "]";
	}



    // Getters and Setters

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
