package com.example.springbootapp.repository;

import com.example.springbootapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByToCard(Long recipient);
}
