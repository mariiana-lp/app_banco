package com.example.demo.entity;


import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "tbl_persons")

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerson;
    private String name;
    private String gender;
    private String identification;
    private int age;
    private String address;
    private String phone;
}
