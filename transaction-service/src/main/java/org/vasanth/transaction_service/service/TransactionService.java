package org.vasanth.transaction_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vasanth.transaction_service.entity.Transaction;
import org.vasanth.transaction_service.repository.TransactionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }
}
