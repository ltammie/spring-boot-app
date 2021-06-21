package com.example.springbootapp.service.impl;

import com.example.springbootapp.model.Transaction;
import com.example.springbootapp.repository.TransactionRepository;
import com.example.springbootapp.service.api.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository repository;

    @Override
    @Transactional
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Optional<Transaction> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    @Transactional
    public Transaction update(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Transaction> getAllByRecipientCard(Long recipient) {
        return repository.findAllByToCard(recipient);
    }
}
