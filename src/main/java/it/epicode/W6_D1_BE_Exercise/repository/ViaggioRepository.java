package it.epicode.W6_D1_BE_Exercise.repository;

import it.epicode.W6_D1_BE_Exercise.model.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViaggioRepository extends JpaRepository<Viaggio, Integer> {}
