package it.epicode.W6_D1_BE_Exercise.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DipendenteDto {

    @NotEmpty(message = "L'username non può essere nullo o vuoto")
    private String username;

    @NotEmpty(message = "Il nome non può essere nullo o vuoto")
    private String nome;

    @NotEmpty(message = "Il cognome non può essere nullo o vuoto")
    private String cognome;

    @NotEmpty(message = "L'email non può essere nullo o vuoto")
    private String email;

}
