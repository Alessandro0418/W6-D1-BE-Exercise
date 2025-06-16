package it.epicode.W6_D1_BE_Exercise.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDto {
    private int idDipendente;
    private int idViaggio;
    private LocalDate dataRichiesta;
}
