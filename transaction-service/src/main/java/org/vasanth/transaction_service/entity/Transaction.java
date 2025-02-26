package org.vasanth.transaction_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String accountNumber; // Links transaction to an account

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private String transactionType; // e.g., DEPOSIT, WITHDRAWAL

    @Column(nullable = false)
    private LocalDateTime transactionDate;
}
