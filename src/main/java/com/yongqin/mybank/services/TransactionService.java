package com.yongqin.mybank.services;

import com.yongqin.mybank.models.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {
    private List<Transaction> transactions = new CopyOnWriteArrayList<>();
    private final String bankSlogan;

    public TransactionService(@Value("${bank.slogan}") String slogan) {
        this.bankSlogan = slogan;
    }

    public List<Transaction> findAll(){
        return this.transactions;
    }

    public Transaction create(BigDecimal amount, String reference){
        ZonedDateTime timestamp = ZonedDateTime.now();

        Transaction transaction = new Transaction(amount,timestamp,reference,bankSlogan);

        transactions.add(transaction);
        return transaction;
    }
}
