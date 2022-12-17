package com.table.relationship.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
