package it.epicode.W6_D1_BE_Exercise.controller;
import it.epicode.W6_D1_BE_Exercise.dto.DipendenteDto;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.model.Dipendente;
import it.epicode.W6_D1_BE_Exercise.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService service;

    @PostMapping
    public Dipendente crea(@RequestBody DipendenteDto dto) {
        return service.saveDipendente(dto);
    }

    @PatchMapping("/{id}/upload")
    public String patch(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws NotFoundException, IOException {
        return service.patchDipendente(id, file);
    }

    @GetMapping
    public List<Dipendente> all() {
        return service.getAllDipendenti();
    }
}
