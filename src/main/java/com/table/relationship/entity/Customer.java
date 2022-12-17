package com.table.relationship.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CUSTOMER")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "CONTACT_NUMBER")
    private String contactNo;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "DATE_OF_BIRTH")
    private String dob;
}
