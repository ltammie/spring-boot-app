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

    @Column(name = "from")
    private Long fromCard;

    @Column(name = "to")
    private Long toCard;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private Date date;

    @JsonIgnoreProperties("transactions")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="card_id")
    private Card card;
}
