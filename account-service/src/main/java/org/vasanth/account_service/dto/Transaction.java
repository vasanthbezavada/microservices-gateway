package org.vasanth.account_service.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    private Long id;
    private String accountNumber;
    private BigDecimal amount;
    private String transactionType; // CREDIT, DEBIT
    private LocalDateTime timestamp;
}
