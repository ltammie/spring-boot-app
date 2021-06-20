package com.example.springbootapp.controller;

import com.example.springbootapp.model.Card;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/card-management")
public class CardController {

    @GetMapping("/cards")
    public List<Card> getAll() {
        return null;
    }

    @GetMapping("/cards/{id}")
    public Card getById(@PathVariable("id") Long id) {
        return new Card();
    }
}
