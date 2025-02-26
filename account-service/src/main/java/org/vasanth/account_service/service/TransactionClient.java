package org.vasanth.account_service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.vasanth.account_service.dto.Transaction;

import java.util.List;

// USING GATEWAY URL
@FeignClient(name = "transaction-service", url = "http://localhost:8088/api/v1/transactions")
public interface TransactionClient {
    @GetMapping("/{accountNumber}")
    List<Transaction> getTransactions(@PathVariable String accountNumber);
}
