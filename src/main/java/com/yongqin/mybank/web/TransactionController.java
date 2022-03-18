package com.yongqin.mybank.web;

import com.yongqin.mybank.dto.TransactionDto;
import com.yongqin.mybank.models.Transaction;
import com.yongqin.mybank.services.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions() {
        return transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction create(@RequestBody @Valid TransactionDto transactionDto) {
        return transactionService.create(transactionDto.getAmount(), transactionDto.getReference(), transactionDto.getReceivingUser());
    }
}