package com.example.pockettrack.service.impl;

import com.example.pockettrack.model.Transaction;
import com.example.pockettrack.model.User;
import com.example.pockettrack.model.enums.TransactionalType;
import com.example.pockettrack.repository.TransactionRepository;
import com.example.pockettrack.repository.UserRepository;
import com.example.pockettrack.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Transaction> getTransactionsByUser(User user) {
        return transactionRepository.findByUser(user);
    }

    @Override
    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {

        User user = userRepository.findById(transaction.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        transaction.setUser(user);
        if (transaction.getType().equals(TransactionalType.INCOME)) {
            user.setBalance(user.getBalance() + transaction.getAmount());
        } else if (transaction.getType().equals(TransactionalType.EXPENSE)) {
            user.setBalance(user.getBalance() - transaction.getAmount());
        }


        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

}
