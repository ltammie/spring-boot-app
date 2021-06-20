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
}