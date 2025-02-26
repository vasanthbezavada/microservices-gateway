package org.vasanth.account_service.service;

import org.springframework.stereotype.Service;
import org.vasanth.account_service.dto.AccountWithTransactionsDTO;
import org.vasanth.account_service.dto.Transaction;
import org.vasanth.account_service.entity.Account;
import org.vasanth.account_service.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionClient transactionClient;

    public AccountService(AccountRepository accountRepository, TransactionClient transactionClient) {
        this.accountRepository = accountRepository;
        this.transactionClient = transactionClient;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public AccountWithTransactionsDTO getAccountWithTransactions(String accountNumber) {
        Account account = getAccountByNumber(accountNumber);
        List<Transaction> transactions = transactionClient.getTransactions(accountNumber);

        return AccountWithTransactionsDTO.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountHolderName(account.getAccountHolderName())
                .email(account.getEmail())
                .balance(account.getBalance())
                .accountType(account.getAccountType())
                .createdAt(account.getCreatedAt())
                .transactions(transactions)
                .build();
    }
}
