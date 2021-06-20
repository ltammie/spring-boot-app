package com.example.springbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private Long cardId;

    @Column(name="card_number")
    private Long cardNumber;

    @Column(name="balance")
    private Long balance;

    @JsonIgnoreProperties("cards")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="client_id")
    private Client client;

    public Card() {
    }

    public Card(Long cardNumber, Long balance, Client client) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.client = client;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardNumber=" + cardNumber +
                ", balance=" + balance +
                '}';
    }
}
