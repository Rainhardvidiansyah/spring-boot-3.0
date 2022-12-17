package com.table.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class UserTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "types", nullable = false)
    @ManyToMany
    @JoinTable(name = "user_transaction_type",
            joinColumns = @JoinColumn(name = "user_transaction_id"),
            inverseJoinColumns = @JoinColumn(name = "types_id")
    )
    @ToString.Exclude
    private List<TransactionTypes> transactionTypes = new ArrayList<>();
}
