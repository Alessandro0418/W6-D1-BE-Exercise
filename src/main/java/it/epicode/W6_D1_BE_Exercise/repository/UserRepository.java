package it.epicode.W6_D1_BE_Exercise.repository;

import it.epicode.W6_D1_BE_Exercise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    public Optional<User> findByusername(String username);
}
