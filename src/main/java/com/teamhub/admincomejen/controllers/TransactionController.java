package com.teamhub.admincomejen.controllers;

import com.teamhub.admincomejen.entities.Transaction;
import com.teamhub.admincomejen.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionController {
    TransactionService service;

    public TransactionController(TransactionService service) {
        this.service=service;
    }

    @GetMapping("/enterprises/{id}/transactions")
    public List<Transaction> getTransactionByEnt(@PathVariable Long id){
        return this.service.getTransactionByEnt(id);
    }

    @GetMapping("/enterprises/{id}/transactions/{id_transactions}")
    public Optional<Transaction> getTransaction(@PathVariable("id_transactions") Long id){
        return service.getTransactionOne(id);
    }

    @PostMapping("/enterprises/{id}/transactions")
    public void postTransaction(@RequestBody Transaction transaction){
        this.service.insertTransaction(transaction);
    }

    @PutMapping("/enterprises/{id}/transactions")
    public void putTransaction(@RequestBody Transaction transaction){
        this.service.updateTransaction(transaction);
    }

    @DeleteMapping(value = "/enterprises/{id}/transactions/{id_transactions}")
    public String deleteTransaction(@PathVariable("id_transactions") Long id){
        return this.service.deleteTransaction(id);
    }

}
