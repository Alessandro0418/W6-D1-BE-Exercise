package it.epicode.W6_D1_BE_Exercise.controller;

import it.epicode.W6_D1_BE_Exercise.dto.PrenotazioneDto;
import it.epicode.W6_D1_BE_Exercise.model.Prenotazione;
import it.epicode.W6_D1_BE_Exercise.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService service;

    @PostMapping
    public Prenotazione crea(@RequestBody PrenotazioneDto dto) {
        return service.creaPrenotazione(dto);
    }

    @GetMapping
    public List<Prenotazione> all() {
        return service.getAllPrenotazioni();
    }
}