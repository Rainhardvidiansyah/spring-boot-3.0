package com.table.relationship.entity;

import com.table.relationship.enumeration.ETYPE;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity @Table(name = "transaction_type")
@NoArgsConstructor
@Getter @Setter @ToString
public class TransactionTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_type_id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_string")
    private ETYPE types;

    public TransactionTypes(ETYPE types){
        this.types = types;
    }

}
