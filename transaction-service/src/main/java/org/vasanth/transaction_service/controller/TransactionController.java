package org.vasanth.transaction_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.vasanth.transaction_service.entity.Transaction;
import org.vasanth.transaction_service.service.TransactionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/{accountNumber}")
    public List<Transaction> getTransactions(@PathVariable String accountNumber) {
        return transactionService.getTransactionsByAccountNumber(accountNumber);
    }
}
