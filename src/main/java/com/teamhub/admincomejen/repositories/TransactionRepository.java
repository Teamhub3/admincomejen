package com.teamhub.admincomejen.repositories;

import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionByEnterprise(Enterprise enterprise);
}
