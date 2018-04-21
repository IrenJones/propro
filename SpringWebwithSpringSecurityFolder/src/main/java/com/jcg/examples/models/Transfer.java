package com.jcg.examples.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

/**
 *
 *  Transfer is a class that helps to work with database table transactions.
 *  This class consists exclusively of private fields and public methods that set or get
 *  values of fields:
 *  - id
 *  - tr_date (date of the transaction)
 *  - tr_sum (sum of the transaction)
 *  - tr_type (type of the transaction)
 *  - card_id (id of the card)
 *  - client_id (id of the client)
 *
 */
@Data
@Entity
@Table(name = "transactions")
public class Transfer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="tr_date")
    private Date trDate;

    @Column(name="tr_sum")
	private Integer trSum;

    @Column(name="tr_type")
	private Integer trType;

    @Column(name="card_id")
	private Integer cardId;

    @Column(name="client_id")
	private Integer clientId;
}
