package com.example.springbootapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_id")
    private Long transactionId;

    @Column(name = "fromCard")
    private Long fromCard;

    @Column(name = "toCard")
    private Long toCard;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "date")
    private Date date;

    @JsonIgnoreProperties("transactions")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="card_id")
    private Card card;

    public Transaction() {
    }

    public Transaction(Long fromCard, Long toCard, Long amount, Date date, Card card) {
        this.fromCard = fromCard;
        this.toCard = toCard;
        this.amount = amount;
        this.date = date;
        this.card = card;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getFromCard() {
        return fromCard;
    }

    public void setFromCard(Long fromCard) {
        this.fromCard = fromCard;
    }

    public Long getToCard() {
        return toCard;
    }

    public void setToCard(Long toCard) {
        this.toCard = toCard;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromCard=" + fromCard +
                ", toCard=" + toCard +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
