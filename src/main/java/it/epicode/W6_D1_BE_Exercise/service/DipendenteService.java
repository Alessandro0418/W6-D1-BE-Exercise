package it.epicode.W6_D1_BE_Exercise.service;

import com.cloudinary.Cloudinary;
import it.epicode.W6_D1_BE_Exercise.dto.DipendenteDto;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.model.Dipendente;
import it.epicode.W6_D1_BE_Exercise.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepo;

    @Autowired
    private Cloudinary cloudinary;

    public Dipendente saveDipendente(DipendenteDto dto) {
        Dipendente d = new Dipendente();
        d.setUsername(dto.getUsername());
        d.setNome(dto.getNome());
        d.setCognome(dto.getCognome());
        d.setEmail(dto.getEmail());
        return dipendenteRepo.save(d);
    }

    public String patchDipendente(Long id, MultipartFile file) throws NotFoundException, IOException {
        Dipendente d = dipendenteRepo.findById(Math.toIntExact(id)).orElseThrow();
        String url = (String) cloudinary.uploader().upload(file.getBytes(), Collections.emptyMap()).get("url");
        d.setImmagineProfiloPath(url);
        dipendenteRepo.save(d);
        return url;
    }

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepo.findAll();
    }
}
