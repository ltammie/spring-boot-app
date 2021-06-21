package com.example.springbootapp.service.impl;

import com.example.springbootapp.model.Card;
import com.example.springbootapp.model.Transaction;
import com.example.springbootapp.repository.CardRepository;
import com.example.springbootapp.repository.TransactionRepository;
import com.example.springbootapp.service.api.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    @Transactional
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    @Transactional
    public Optional<Card> getById(Long id) {
        return cardRepository.findById(id);
    }

    @Override
    @Transactional
    public Card create(Card card) {
        return cardRepository.save(card);
    }

    @Override
    @Transactional
    public Card update(Card card) {
        return cardRepository.save(card);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Card getByCardNumber(Long cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Override
    @Transactional
    public Card updateBalanceByCardNumber(Long cardNumber, Long balance) {
        Card card = cardRepository.findByCardNumber(cardNumber);
        card.setBalance(card.getBalance() + balance);
        return cardRepository.save(card);
    }

    @Override
    @Transactional
    public List<String> getTransactionInfo(Long sender, Long recipient) {
        Card senderCard = cardRepository.findByCardNumber(sender);
        Card recipientCard = cardRepository.findByCardNumber(recipient);
        List<String> info = new ArrayList<>();
        info.add(senderCard.getClient().getName() + " " + senderCard.getClient().getSurname());
        info.add(recipientCard.getClient().getName() + " " + recipientCard.getClient().getSurname());
        return info;
    }

    @Override
    @Transactional
    public Boolean executeTransaction(Long sender, Long recipient, Long amount) {
        Card senderInDB = cardRepository.findByCardNumber(sender);
        if (senderInDB.getBalance() - amount < 0)
            return false;
        Card recipientInDB = cardRepository.findByCardNumber(recipient);
        senderInDB.setBalance(senderInDB.getBalance() - amount);
        recipientInDB.setBalance(recipientInDB.getBalance() + amount);
        cardRepository.save(senderInDB);
        cardRepository.save(recipientInDB);

        Date date = new Date(System.currentTimeMillis());
        Transaction sTransaction = new Transaction(
                senderInDB.getCardNumber(),
                recipientInDB.getCardNumber(),
                -amount,
                date,
                senderInDB
                );
        Transaction rTransaction = new Transaction(
                recipientInDB.getCardNumber(),
                senderInDB.getCardNumber(),
                amount,
                date,
                recipientInDB
        );
        transactionRepository.save(sTransaction);
        transactionRepository.save(rTransaction);
        return true;
    }

}
