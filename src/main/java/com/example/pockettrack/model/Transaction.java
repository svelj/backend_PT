package com.example.pockettrack.model;

import com.example.pockettrack.model.enums.TransactionalType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    private Double amount;
    private String category;

    @Enumerated(EnumType.STRING)
    private TransactionalType type;

    private LocalDate date;
    private String description;

    public Transaction() {
    }
    public Transaction(Double amount, String description,TransactionalType type, User user, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.user = user;
        this.date = date;
    }
}
