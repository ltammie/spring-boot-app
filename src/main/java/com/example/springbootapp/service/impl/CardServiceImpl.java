package com.example.springbootapp.service.impl;

import com.example.springbootapp.model.Card;
import com.example.springbootapp.repository.CardRepository;
import com.example.springbootapp.service.api.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository repository;

    @Override
    @Transactional
    public List<Card> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Optional<Card> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Card create(Card card) {
        return repository.save(card);
    }

    @Override
    @Transactional
    public Card update(Card card) {
        return repository.save(card);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public Card getByCardNumber(Long cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }

    @Override
    @Transactional
    public Card updateBalanceByCardNumber(Long cardNumber, Long balance) {
        Card card = repository.findByCardNumber(cardNumber);
        card.setBalance(balance);
        return repository.save(card);
    }

}
