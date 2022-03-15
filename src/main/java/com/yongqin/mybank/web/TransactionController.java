package com.yongqin.mybank.web;

import com.yongqin.mybank.dto.TransactionDto;
import com.yongqin.mybank.models.Transaction;
import com.yongqin.mybank.services.TransactionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String main() {
        return "Hello World, this is my bank page!";
    }

    @GetMapping(value="/transactions", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Transaction> index() {
        return transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody @Valid TransactionDto transactionDto){
        return transactionService.create(transactionDto.getAmount(),transactionDto.getReference());
    }
}
