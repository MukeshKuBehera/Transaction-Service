package com.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.transaction.entity.Transaction;
import com.transaction.repo.TransactionRepository;

public class TransactionService {
	
	@Autowired
	 private TransactionRepository transactionRepository;

	    public List<Transaction> getAllTransactions(){

	        return transactionRepository.findAll();
	    }

	    public Transaction getTransactionById(String id){
	        return transactionRepository.findById(id).orElse(null);
	    }
	    public Transaction createTransaction(Transaction transaction){
	        return transactionRepository.save(transaction);
	    }
	    public Transaction updateTransaction(Long id,Transaction updatedTransaction){
	        Transaction existTransaction=transactionRepository.findById(id).orElse(null);

	        if(existTransaction!=null){
	            //update transaction details
	            existTransaction.setTransactionId(updatedTransaction.getTransactionId());
	            existTransaction.setType(updatedTransaction.getType());
	            existTransaction.setTimestamp(updatedTransaction.getTimestamp());
	            existTransaction.setAmount(updatedTransaction.getAmount());
	            existTransaction.setAccountNumber(updatedTransaction.getAccountNumber());

	            return transactionRepository.save(updatedTransaction);
	        }
	        return null;
	    }

	    //create findbyid custom method in repo
	    public boolean deleteTransaction(String transactionId){
	        Transaction existingTransaction = transactionRepository.findById(transactionId).orElse(null);
	        if (existingTransaction != null) {
	            transactionRepository.delete(existingTransaction);
	            return true;
	        }
	        return false; // Return false if the transaction does not exist
	    }


}
