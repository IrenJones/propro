package com.jcg.examples.models;

import lombok.Data;

import javax.persistence.*;

/**
 *
 *  BankAccount is a class that helps to work with database table bank_accounts.
 *  This class consists exclusively of private fields and public methods that set or get
 *  values of fields:
 *  - id
 *  - balance
 *  - is_blocked
 *
 */
@Data
@Entity
@Table(name = "bank_accounts")
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int balance;

    @Column(name="is_blocked")
    private boolean isBlocked;
}
