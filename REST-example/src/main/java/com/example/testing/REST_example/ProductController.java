package com.example.testing.REST_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping
    public List<ProductEntity> getAllProducts() {
        System.out.println("inside get product");
        try {
            List<ProductEntity> products = productRepository.findAll();
            System.out.println("Products found: " + products);
            return products;
        } catch (Exception e) {
            System.out.println("Error fetching products: " + e.getMessage());
            throw e;
        }
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductEntity> getProductByCode(@PathVariable String productCode) {
        Optional<ProductEntity> product = productRepository.findById(productCode);
        return product.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductEntity product) {
        ProductEntity savedProduct = productRepository.save(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    

    @PutMapping("/{productCode}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String productCode, @RequestBody ProductEntity product) {
        if (!productRepository.existsById(productCode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        product.setProductCode(productCode);
        ProductEntity updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productCode) {
        if (!productRepository.existsById(productCode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        productRepository.deleteById(productCode);
        return ResponseEntity.noContent().build();
    }
}

