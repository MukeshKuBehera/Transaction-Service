package com.transaction.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transactionId;

    private String accountNumber;
    private double amount;
    private TransactionType type;
    private LocalDateTime timestamp;
}
