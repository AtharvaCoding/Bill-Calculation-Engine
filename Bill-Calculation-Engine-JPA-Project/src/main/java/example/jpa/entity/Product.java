package example.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "ProductCode", nullable = false, length = 20)
    private String productCode;

    @Column(name = "ProductName", nullable = false, length = 100)
    private String productName;

    @Column(name = "UnitPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    // Constructors
    public Product() {
    }

    public Product(String productCode, String productName, BigDecimal unitPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.unitPrice = unitPrice;
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

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product [productCode=" + productCode + ", productName=" + productName + ", unitPrice=" + unitPrice + "]";
    }
}
