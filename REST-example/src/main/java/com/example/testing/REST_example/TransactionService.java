package com.example.testing.REST_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    // Method to fetch transactions based on customer ID and transaction month and year
    public List<TransactionEntity> getTransactionsForCustomerByMonth(Long customerId, int month, int year) {
        return transactionRepository.findByCustomerIdAndMonthAndYear(customerId, month, year);
    }
}