package com.example.springbootapp.controller;

import com.example.springbootapp.model.Transaction;
import com.example.springbootapp.service.api.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction-management")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAll();
    }

    @GetMapping("/transactions/by-recipient")
    public List<Transaction> getAllTransactionsByRecipient(@RequestParam Long recipient) {
        return transactionService.getAllByRecipientCard(recipient);
    }
}
