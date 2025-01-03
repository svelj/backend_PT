package com.example.pockettrack.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private double balance;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Transaction> transactionList;

    public User() {
        this.balance = 0.0;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
    }

    public User(String username, String password,double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

}
