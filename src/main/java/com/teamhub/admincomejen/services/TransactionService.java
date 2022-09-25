package com.teamhub.admincomejen.services;

import com.teamhub.admincomejen.entities.Transaction;
import com.teamhub.admincomejen.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    public List<Transaction> getTransactions(){
        return this.transactionRepository.findAll();
    }

    public List<Transaction> getTransactionByEnterpriseId(Long id){
        return this.transactionRepository.findByEnterprise_Id(id);
    }

    public Transaction getTransactionById(Long id) throws Exception{
        Optional<Transaction> transactionOptional = this.transactionRepository.findById(id);
        if (transactionOptional.isPresent()){
            return transactionOptional.get();
        }else {
            throw new Exception("La Transacion con id = " + id + " no exite");
        }

    }
    public Long getUltimoId(){
        List<Transaction> transactions = this.transactionRepository.findAll();
        if(transactions.size() > 0){
            return transactions.get(transactions.size()-1).getId();
        }else{
            return 0L;
        }
    }
    public  Transaction postTransaction(Transaction transaction){
        return this.transactionRepository.save(transaction);
    }

    public Transaction patchTransaction(Transaction transaction_param, Long id) throws Exception{
        try {
            Transaction transactionDB = getTransactionById(id);
            if (transaction_param.getConcept() != null){
                transactionDB.setConcept(transaction_param.getConcept());
            }
            if (transaction_param.getAmount() != transactionDB.getAmount()){
                transactionDB.setAmount(transaction_param.getAmount());
            }
            transactionDB.setUpdatedAt(LocalDate.now());
            return postTransaction(transactionDB);

        }catch (Exception e){
            throw new Exception("La transaccion no se actualizo");
        }
    }

    public String deleteEnterprise(Long id){
        try {
            this.transactionRepository.deleteById(id);
            return "Transaccion eliminada exitosamente!";
        }catch (Exception e){
            return "La Transaccion con id = " + id + " no se pudo eliminar o no existe en la base de datos!";
        }
    }

}
