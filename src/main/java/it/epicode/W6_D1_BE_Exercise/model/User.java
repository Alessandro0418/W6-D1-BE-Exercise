package it.epicode.W6_D1_BE_Exercise.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    private String nome;

    private String cognome;

    @Column(unique = true)
    private String email;

    private String password;
}
