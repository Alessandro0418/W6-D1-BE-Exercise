package it.epicode.W6_D1_BE_Exercise.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ViaggioDto {
    @NotEmpty(message = "La destinazione non può essere null o vuoto")
    private String destinazione;

    @NotEmpty(message = "La data non può essere null o vuoto")
    private LocalDate data;
}
