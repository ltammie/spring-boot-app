package com.example.springbootapp.controller;

import com.example.springbootapp.model.Card;
import com.example.springbootapp.service.api.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card-management")
public class CardController {
    @Autowired
    private CardService service;

    @GetMapping("/cards")
    public List<Card> getAll() {
        return null;
    }

    @GetMapping("/cards/{id}")
    public Card getById(@PathVariable("id") Long id) {
        return new Card();
    }

    @PostMapping("/cards")
    public Card addCard(@RequestBody Card card) {
        System.out.println(card);
        return service.create(card);
    }

    @PutMapping("/cards")
    public Card updateCard(@RequestBody Card card) {
        return service.update(card);
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCardById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
