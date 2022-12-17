package com.table.relationship.entity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Timestamp;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class TransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @Valid
    @NotNull
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_transaction_id")
    @Valid
    @NonNull
    @ToString.Exclude
    private UserTransaction userTransaction;

    private final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
}
