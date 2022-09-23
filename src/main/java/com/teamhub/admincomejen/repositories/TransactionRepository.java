package com.teamhub.admincomejen.repositories;

import com.teamhub.admincomejen.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    public List<Transaction> findByEnterprise_Id(Long id);
}
