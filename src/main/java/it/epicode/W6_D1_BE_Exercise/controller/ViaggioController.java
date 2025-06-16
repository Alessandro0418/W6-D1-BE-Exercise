package it.epicode.W6_D1_BE_Exercise.controller;

import it.epicode.W6_D1_BE_Exercise.dto.ViaggioDto;
import it.epicode.W6_D1_BE_Exercise.enumeration.StatoViaggio;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.model.Dipendente;
import it.epicode.W6_D1_BE_Exercise.model.Viaggio;
import it.epicode.W6_D1_BE_Exercise.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService service;

    @PostMapping
    public Viaggio crea(@RequestBody ViaggioDto dto) {
        return service.saveViaggio(dto);
    }

    @PatchMapping("/{id}/stato")
    public Viaggio cambiaStato(@PathVariable Long id, @RequestParam StatoViaggio stato) {
        return service.cambiaStato(id, stato);
    }

    @GetMapping
    public List<Viaggio> all() {
        return service.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Dipendente getById(@PathVariable int id) throws NotFoundException, IOException {
        return service.getById(id);
    }
}