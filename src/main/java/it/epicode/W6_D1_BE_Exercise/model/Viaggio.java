package it.epicode.W6_D1_BE_Exercise.model;

import it.epicode.W6_D1_BE_Exercise.enumeration.StatoViaggio;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String destinazione;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato = StatoViaggio.IN_PROGRAMMA;
}
