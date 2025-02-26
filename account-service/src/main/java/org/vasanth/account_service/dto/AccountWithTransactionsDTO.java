package org.vasanth.account_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountWithTransactionsDTO {
    private Long id;
    private String accountNumber;
    private String accountHolderName;
    private String email;
    private BigDecimal balance;
    private String accountType;
    private LocalDateTime createdAt;
    private List<Transaction> transactions;
}