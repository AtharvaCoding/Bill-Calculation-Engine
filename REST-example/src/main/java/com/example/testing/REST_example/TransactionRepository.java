package com.example.testing.REST_example;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
//    
//    @Query("SELECT t FROM TransactionEntity t WHERE t.customer.customerId = :customerId AND FUNCTION('MONTH', t.transactionDate) = :month AND FUNCTION('YEAR', t.transactionDate) = :year")
//    List<TransactionEntity> findAllByCustomerIdAndMonth(@Param("customerId") Long customerId, @Param("month") int month, @Param("year") int year);
//}


//public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
//    
//    @Query("SELECT t FROM TransactionEntity t WHERE t.customer.customerId = :customerId AND FUNCTION('MONTH', t.transactionDate) = :month AND FUNCTION('YEAR', t.transactionDate) = :year")
//    List<TransactionEntity> findByCustomerIdAndMonthAndYear(@Param("customerId") Long customerId, @Param("month") int month, @Param("year") int year);
//}

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    
    @Query("SELECT t FROM TransactionEntity t WHERE t.customer.customerId = :customerId AND EXTRACT(MONTH FROM t.transactionDate) = :month AND EXTRACT(YEAR FROM t.transactionDate) = :year")
    List<TransactionEntity> findByCustomerIdAndMonthAndYear(@Param("customerId") Long customerId, @Param("month") int month, @Param("year") int year);
}

//public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
//
//    @Query("SELECT t FROM TransactionEntity t WHERE t.customer.customerId = :customerId AND EXTRACT(MONTH FROM t.transactionDate) = :month AND EXTRACT(YEAR FROM t.transactionDate) = :year")
//    List<TransactionEntity> findByCustomerIdAndMonthAndYear(@Param("customerId") Long customerId, @Param("month") int month, @Param("year") int year);
//}
