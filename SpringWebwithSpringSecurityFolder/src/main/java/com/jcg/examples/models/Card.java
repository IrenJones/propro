package com.jcg.examples.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 *
 *  Card is a class that helps to work with database table cards.
 *  This class consists exclusively of private fields and public methods that set or get
 *  values of fields:
 *  - id
 *  - card_number (number of the card)
 *  - account_id (id of the bank account)
 *  - client_id (id of the client)
 *
 */
@Data
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cardNumber;

    @Column(name="account_id")
    private Integer accountId;

    @Column(name="client_id")
    private Integer clientId;
}
