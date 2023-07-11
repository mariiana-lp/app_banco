package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long idAccount;
    private String number;
    private String type;
    private int balance;
    private boolean Status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPerson")
    private Client client;
    @Transient
    private String nombreCliente;


}
