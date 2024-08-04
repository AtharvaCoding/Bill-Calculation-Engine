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
//    	TransactionEntity savedTransaction = transactionRepository.save(transaction);
//        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
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
    
    
//    private final TransactionRepository transactionRepository;
//    private final CustomerRepository customerRepository;
//
//    public TransactionController(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
//        this.transactionRepository = transactionRepository;
//        this.customerRepository = customerRepository;
//    }

//    @PostMapping("/calculate-bill")
//    public ResponseEntity<BillResponse> calculateBill(@RequestParam Long customerId,
//                                                      @RequestParam int billMonth,
//                                                      @RequestParam int billYear) {
//        // Get the customer details
//        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
//
//        // Get the transactions for the given month and year
//        YearMonth targetMonth = YearMonth.of(billYear, billMonth);
//        List<TransactionEntity> transactions = transactionRepository.findAllByCustomerIdAndMonth(
//                customerId,
//                targetMonth.atDay(1),
//                targetMonth.atEndOfMonth()
//        );
//
//        // Calculate the total bill amount
//        double totalBillAmount = transactions.stream()
//                .mapToDouble(t -> t.getProduct().getUnitPrice() * t.getQuantity())
//                .sum();
//
//        // Prepare the response
//        BillResponse billResponse = new BillResponse();
//        billResponse.setCustomerName(customer.getName());
//        billResponse.setTotalBillAmount(totalBillAmount);
//
//        return ResponseEntity.ok(billResponse);
//    }
    
//    @GetMapping("/transactions/{customerId}")
//    public List<TransactionEntity> getTransactions(@PathVariable Long customerId, @RequestParam int month, @RequestParam int year) {
//        return TransactionService.getTransactionsForCustomerByMonth(customerId, month, year);
//    }
    
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
