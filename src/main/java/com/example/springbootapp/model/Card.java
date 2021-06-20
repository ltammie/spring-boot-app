package com.example.springbootapp.model;

public class Card {
    private Long id;
    private Long cardNumber;
    private Long balance;

    public Card() {
    }

    public Card(Long id, Long cardNumber, Long balance) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", balance=" + balance +
                '}';
    }
}
