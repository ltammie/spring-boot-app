package com.example.springbootapp.controller;

import com.example.springbootapp.model.Card;
import com.example.springbootapp.service.api.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/card-management")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/cards")
    public List<Card> getAll() {
        return cardService.getAll();
    }

    @GetMapping("/cards/{id}")
    public Card getById(@PathVariable("id") Long id) {
        return cardService.getById(id).orElseThrow(() -> new ExpressionException("No client"));
    }

    @PostMapping("/cards")
    public Card addCard(@RequestBody Card card) {
        return cardService.create(card);
    }

    @PutMapping("/cards")
    public Card updateCard(@RequestBody Card card) {
        return cardService.update(card);
    }

    @DeleteMapping("/cards/{id}")
    public void deleteCardById(@PathVariable("id") Long id) {
        cardService.deleteById(id);
    }

    /*
    Баланс карты по номеру
     */
    @GetMapping("/balance")
    public Long getBalance(@RequestParam Long cardNumber) {
        return cardService.getByCardNumber(cardNumber).getBalance();
    }

    /*
    Пополнение баланса по номеру
     */
    @PutMapping("/balance")
    public Card updateBalance(@RequestBody Card card) {
        return cardService.updateBalanceByCardNumber(card.getCardNumber(), card.getBalance());
    }

    /*
    Получение фио отправителя и получателя
     */
    @GetMapping("/transaction/info")
    public Map<String, String> getTransactionInfo(@RequestParam Long sender, @RequestParam Long recipient) {
        return cardService.getTransactionInfo(sender, recipient);
    }

    @PostMapping("/transaction/execute")
    public Boolean executeTransaction(@RequestParam Long sender, @RequestParam Long recipient, @RequestParam Long amount) {
        return cardService.executeTransaction(sender, recipient, amount);
    }
}
