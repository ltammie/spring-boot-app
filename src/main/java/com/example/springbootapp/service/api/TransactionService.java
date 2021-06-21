package com.example.springbootapp.service.api;

import com.example.springbootapp.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    List<Transaction> getAll();
    Optional<Transaction> getById(Long id);
    Transaction create(Transaction transaction);
    Transaction update(Transaction transaction);
    void deleteById(Long id);
}
