package com.toll.tollbackend.controller;

import com.toll.tollbackend.model.Transaction;
import com.toll.tollbackend.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:5173")
public class TransactionController {

    private final TransactionRepository repository;

    public TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Transaction saveTransaction(
            @RequestBody Transaction transaction) {

        return repository.save(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {

        return repository.findAll();
    }

    @GetMapping("/search/{vehicleNumber}")
    public List<Transaction> searchTransaction(
            @PathVariable String vehicleNumber) {

        return repository
                .findByVehicleNumberContainingIgnoreCase(
                        vehicleNumber
                );
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(
            @PathVariable String id) {

        repository.deleteById(id);
    }
}