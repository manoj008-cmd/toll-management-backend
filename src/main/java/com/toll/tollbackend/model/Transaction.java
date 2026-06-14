package com.toll.tollbackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    private String vehicleNumber;
    private String vehicleType;
    private String tollPlaza;
    private String dateTime;
    private int amount;
}