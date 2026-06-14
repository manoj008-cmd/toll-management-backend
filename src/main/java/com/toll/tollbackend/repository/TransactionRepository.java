package com.toll.tollbackend.repository;

import com.toll.tollbackend.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository
        extends MongoRepository<Transaction, String> {

    List<Transaction> findByVehicleNumberContainingIgnoreCase(
            String vehicleNumber
    );
}