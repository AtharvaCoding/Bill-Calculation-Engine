package com.example.testing.REST_example;



import com.example.testing.REST_example.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    // You can define custom query methods here if needed
}
