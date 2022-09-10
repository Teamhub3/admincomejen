package com.teamhub.admincomejen.services;

import com.teamhub.admincomejen.entities.Transaction;
import com.teamhub.admincomejen.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private TransactionRepository repository;
    private EnterpriseService enterpriseService;

    public TransactionService(TransactionRepository repository, EnterpriseService enterpriseService){
        this.enterpriseService = enterpriseService;
        this.repository = repository;
    }

    public List<Transaction> getTransactionByEnt(Long id){
        return this.repository.findTransactionByEnterprise(enterpriseService.getEnterpriseOne(id));
    }

    public Optional<Transaction> getTransactionOne(long id){
        return this.repository.findById(id);
    }
    public void insertTransaction(Transaction transaction){
        this.repository.save(transaction);
    }
    public void updateTransaction(Transaction transaction){
        this.repository.save(transaction);
    }
    public String deleteTransaction(Long id){
        try {
            this.repository.deleteById(id);

        }catch (Exception exception){
            return "The enterprise with id = "+ id +" could not be eliminated.";
        }
        return null;
    }

}
