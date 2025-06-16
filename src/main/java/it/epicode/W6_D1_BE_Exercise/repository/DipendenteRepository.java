package it.epicode.W6_D1_BE_Exercise.repository;

import it.epicode.W6_D1_BE_Exercise.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    Optional<Dipendente> findByUsername(String username);
}
