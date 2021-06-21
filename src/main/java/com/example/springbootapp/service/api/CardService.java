package com.example.springbootapp.service.api;

import com.example.springbootapp.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardService {
    List<Card> getAll();
    Optional<Card> getById(Long id);
    Card create(Card card);
    Card update(Card card);
    void deleteById(Long id);
    Card getByCardNumber(Long cardNumber);
    Card updateBalanceByCardNumber(Long cardNumber, Long balance);
    List<String> getTransactionInfo(Long sender, Long recipient);
    Boolean executeTransaction(Long sender, Long recipient, Long amount);
}
