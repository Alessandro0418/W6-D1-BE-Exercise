package it.epicode.W6_D1_BE_Exercise.service;

import it.epicode.W6_D1_BE_Exercise.dto.PrenotazioneDto;
import it.epicode.W6_D1_BE_Exercise.model.Dipendente;
import it.epicode.W6_D1_BE_Exercise.model.Prenotazione;
import it.epicode.W6_D1_BE_Exercise.model.Viaggio;
import it.epicode.W6_D1_BE_Exercise.repository.DipendenteRepository;
import it.epicode.W6_D1_BE_Exercise.repository.PrenotazioneRepository;
import it.epicode.W6_D1_BE_Exercise.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepo;

    @Autowired
    private DipendenteRepository dipendenteRepo;

    @Autowired
    private ViaggioRepository viaggioRepo;

    public Prenotazione creaPrenotazione(PrenotazioneDto dto) {
        Dipendente d = dipendenteRepo.findById(dto.getIdDipendente()).orElseThrow();

        if (prenotazioneRepo.existsByDipendenteAndDataRichiesta(d, dto.getDataRichiesta())) {
            throw new IllegalArgumentException("Dipendente già impegnato in questa data");
        }

        Viaggio v = viaggioRepo.findById(dto.getIdDipendente()).orElseThrow();

        Prenotazione p = new Prenotazione();
        p.setDipendente(d);
        p.setViaggio(v);
        p.setDataRichiesta(dto.getDataRichiesta());
        return prenotazioneRepo.save(p);
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneRepo.findAll();
    }

}