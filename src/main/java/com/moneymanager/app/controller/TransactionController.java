package com.moneymanager.app.controller;

import com.moneymanager.app.model.Transaction;
import com.moneymanager.app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

// CRITICAL: Allows frontend running on http://localhost:3000 (or whichever port) to access this API.
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    // Inject the Repository to use its database methods
    @Autowired
    private TransactionRepository transactionRepository;

    // GET: Retrieve all transactions - maps to GET /api/transactions
    @GetMapping
    public List<Transaction> getAllTransactions() {
        // Retrieve all transactions from the database
        return transactionRepository.findAll();
    }

    // POST: Create a new transaction - maps to POST /api/transactions
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        // Set the current date/time when the transaction is saved
        transaction.setDate(LocalDateTime.now());

        // Save the transaction to the database
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Return the saved object with 201 Created status
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    // DELETE: Delete a transaction by ID - maps to DELETE /api/transactions/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            // Return 204 No Content status on successful deletion
            return ResponseEntity.noContent().build();
        } else {
            // Return 404 Not Found if ID doesn't exist
            return ResponseEntity.notFound().build();
        }
    }
}
