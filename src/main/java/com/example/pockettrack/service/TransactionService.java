package com.example.pockettrack.service;

import com.example.pockettrack.model.Transaction;
import com.example.pockettrack.model.User;

import java.util.List;

public interface TransactionService {

    public List<Transaction> getTransactionsByUser(User user);

    public List<Transaction> getTransactionsByUserId(Long userId);
    public Transaction createTransaction(Transaction transaction);



    List<Transaction> getAllTransactions();
    void deleteTransaction(Long id);

}
