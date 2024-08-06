package com.example.testing.REST_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import java.time.YearMonth;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public List<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @PostMapping
    public TransactionEntity createTransaction(@RequestBody TransactionEntity transaction) {
        return transactionRepository.save(transaction);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionEntity> getTransactionById(@PathVariable Long id) {
        return transactionRepository.findById(id)
                .map(transaction -> ResponseEntity.ok().body(transaction))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionEntity> updateTransaction(@PathVariable Long id, @RequestBody TransactionEntity transactionDetails) {
        return transactionRepository.findById(id)
                .map(transaction -> {
                    transaction.setTransactionDate(transactionDetails.getTransactionDate());
                    transaction.setCustomer(transactionDetails.getCustomer());
                    transaction.setProduct(transactionDetails.getProduct());
                    transaction.setQuantity(transactionDetails.getQuantity());
                    TransactionEntity updatedTransaction = transactionRepository.save(transaction);
                    return ResponseEntity.ok().body(updatedTransaction);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        return transactionRepository.findById(id)
                .map(transaction -> {
                    transactionRepository.delete(transaction);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
    
    @Autowired
    private TransactionService transactionService;

    // Endpoint to get transactions for a customer by month and year
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<TransactionEntity>> getTransactionsForCustomerByMonth(
            @PathVariable Long customerId,
            @RequestParam int month,
            @RequestParam int year) {
        List<TransactionEntity> transactions = transactionService.getTransactionsForCustomerByMonth(customerId, month, year);
        return ResponseEntity.ok(transactions);
    }
}
