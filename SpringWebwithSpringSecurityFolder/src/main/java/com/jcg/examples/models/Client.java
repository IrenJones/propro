package com.jcg.examples.models;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 *  Client is a class that helps to work with database table clients.
 *  This class consists exclusively of private fields and public methods that set or get
 *  values of fields:
 *  - id
 *  - first_name
 *  - last_name
 *  - surname
 *  - user_id (id of the user)
 */
@Data
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private String surname;

    @Column(name="user_id")
    private Integer userId;
}

