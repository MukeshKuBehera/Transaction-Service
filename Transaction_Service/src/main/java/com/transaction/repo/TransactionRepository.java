package com.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,String> {

}
