package it.epicode.W6_D1_BE_Exercise.service;

import it.epicode.W6_D1_BE_Exercise.dto.ViaggioDto;
import it.epicode.W6_D1_BE_Exercise.enumeration.StatoViaggio;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.model.Dipendente;
import it.epicode.W6_D1_BE_Exercise.model.Viaggio;
import it.epicode.W6_D1_BE_Exercise.repository.DipendenteRepository;
import it.epicode.W6_D1_BE_Exercise.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepo;

    @Autowired
    private DipendenteRepository dipendenteRepo;

    public Viaggio saveViaggio(ViaggioDto dto) {
        Viaggio v = new Viaggio();
        v.setDestinazione(dto.getDestinazione());
        v.setData(dto.getData());
        return viaggioRepo.save(v);
    }

    public Viaggio cambiaStato(Long id, StatoViaggio nuovoStato) {
        Viaggio v = viaggioRepo.findById(Math.toIntExact(id)).orElseThrow();
        v.setStato(nuovoStato);
        return viaggioRepo.save(v);
    }

    public Dipendente getById(int id) throws NotFoundException, IOException {
        return dipendenteRepo.findById((int) id)
                .orElseThrow(() -> new IOException("Studente con matricola " + id + " non presente"));
    }


    public List<Viaggio> getAllViaggi() {
        return viaggioRepo.findAll();
    }
}
