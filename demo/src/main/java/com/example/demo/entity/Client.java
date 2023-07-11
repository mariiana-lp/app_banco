package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Client extends Person{
    private int password;
    private boolean status;

}
