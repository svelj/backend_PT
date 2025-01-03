package com.example.pockettrack.web.controller;

import com.example.pockettrack.model.Transaction;
import com.example.pockettrack.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public List<Transaction> allTransactions(){
        return transactionService.getAllTransactions();
    }

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return  transactionService.createTransaction(transaction);
    }

    @GetMapping("/user/{id}")
    public List<Transaction> listUserTransactions(@PathVariable Long id)
    {
        return  transactionService.getTransactionsByUserId(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTransaction(@PathVariable Long id)
    {
        transactionService.deleteTransaction(id);
    }
}
