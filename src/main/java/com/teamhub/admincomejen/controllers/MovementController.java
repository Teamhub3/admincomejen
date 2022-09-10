package com.teamhub.admincomejen.controllers;

import com.teamhub.admincomejen.entities.Transaction;
import com.teamhub.admincomejen.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovementController {
    TransactionService service;

    public MovementController(TransactionService service) {
        this.service=service;
    }

    @GetMapping("/enterprise/{id}/transactions")
    public List<Transaction> getTransactionByEnt(@PathVariable Long id){
        return this.service.getTransactionByEnt(id);
    }

    @GetMapping("/enterprises/{id}/transactions/{id_transactions}")
    public Optional<Transaction> getMovementOne(@PathVariable("id_transactions") Long id){
        return service.getTransactionOne(id);
    }

    @PostMapping("/enterprises/{id}/transactions")
    public void postMovement(@RequestBody Transaction transaction){
        this.service.insertTransaction(transaction);
    }

    @PutMapping("/enterprises/{id}/transactions")
    public void putMovement(@RequestBody Transaction transaction){
        this.service.updateTransaction(transaction);
    }

    @DeleteMapping(value = "/enterprises/{id}/transactions")
    public String deleteMovement(@PathVariable("id") Long id){
        return this.service.deleteTransaction(id);
    }

}
