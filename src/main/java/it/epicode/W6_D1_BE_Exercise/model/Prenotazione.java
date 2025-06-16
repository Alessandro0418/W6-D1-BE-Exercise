package it.epicode.W6_D1_BE_Exercise.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Dipendente dipendente;

    @ManyToOne
    private Viaggio viaggio;

    private LocalDate dataRichiesta;
}
