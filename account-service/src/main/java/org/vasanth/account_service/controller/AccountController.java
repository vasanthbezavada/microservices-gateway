package org.vasanth.account_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vasanth.account_service.dto.AccountWithTransactionsDTO;
import org.vasanth.account_service.entity.Account;
import org.vasanth.account_service.service.AccountService;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountByNumber(accountNumber));
    }

    @GetMapping("/{accountNumber}/transactions")
    public ResponseEntity<AccountWithTransactionsDTO> getAccountWithTransactions(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.getAccountWithTransactions(accountNumber));
    }
}
