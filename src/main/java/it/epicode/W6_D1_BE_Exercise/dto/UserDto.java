package it.epicode.W6_D1_BE_Exercise.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {
    @NotEmpty(message = "Il nome non può essere vuoto")
    private String nome;

    @NotEmpty(message = "Il cognome non può essere vuoto")
    private String cognome;

    @NotEmpty(message = "L'username non può essere vuoto")
    private String username;

    @NotEmpty(message = "la password non può essere vuoto")
    private String password;
}
