package com.jcg.examples.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 *  User is a class that helps to work with database table users.
 *  values of fields:
 *  - id
 *  - login
 *  - password
 *  - is_admin (field for user's role in the system)
 *
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="is_admin")
    private String isAdmin;

    private String login;
    private String password;
}
