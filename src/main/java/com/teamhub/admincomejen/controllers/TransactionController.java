package com.teamhub.admincomejen.controllers;

import com.teamhub.admincomejen.entities.Transaction;
import com.teamhub.admincomejen.entities.TransactionResponse;
import com.teamhub.admincomejen.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(){
        return new ResponseEntity<List<Transaction>>(
                this.transactionService.getTransactions(),
                HttpStatus.OK
        );
    }

    @GetMapping("/enterprises/{id}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionByEnterprise(@PathVariable Long id){
        return new ResponseEntity<List<Transaction>>(
                this.transactionService.getTransactionByEnterpriseId(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/enterprises/{id}/transactions")
    public ResponseEntity<TransactionResponse> postTransaction(@RequestBody Transaction transaction){
        return new ResponseEntity<>(
                new TransactionResponse("Transaccion creada exitosamente", this.transactionService.postTransaction(transaction)),
                HttpStatus.OK
        );
    }

    @PatchMapping("/enterprises/{id}/transactions/{id_transaction}")
    public ResponseEntity<TransactionResponse> patchTransaction(@RequestBody Transaction transaction, @PathVariable("id_transaction") Long id){
        try {
            return new ResponseEntity<>(
                    new TransactionResponse("Transaccion actualizada exitosamente", this.transactionService.patchTransaction(transaction,id)),
                    HttpStatus.OK
            );

        }catch (Exception e){
            return new ResponseEntity<>(
                    new TransactionResponse(e.getMessage(), null),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/enterprises/{id}/transactions/{id_transaction}")
    public ResponseEntity<TransactionResponse> deleteTransaction(@PathVariable("id_transaction") Long id){
        return new ResponseEntity<>(
                new TransactionResponse(this.transactionService.deleteEnterprise(id),null),
                HttpStatus.OK
        );
    }
}
