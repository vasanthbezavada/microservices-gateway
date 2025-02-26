package org.vasanth.transaction_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vasanth.transaction_service.entity.Transaction;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountNumber(String accountNumber);
}
