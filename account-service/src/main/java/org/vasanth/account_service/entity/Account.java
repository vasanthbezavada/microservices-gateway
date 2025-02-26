package org.vasanth.account_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountNumber; // Unique account number

    @Column(nullable = false)
    private String accountHolderName; // Account holder's full name

    @Column(nullable = false, unique = true)
    private String email; // Email for notifications

    @Column(nullable = false)
    private BigDecimal balance; // Account balance

    @Column(nullable = false)
    private String accountType; // Savings, Current, etc.

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // When the account was created

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}

