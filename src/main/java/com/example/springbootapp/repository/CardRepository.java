package com.example.springbootapp.repository;

import com.example.springbootapp.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByCardNumber(Long cardNumber);
}
