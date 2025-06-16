package it.epicode.W6_D1_BE_Exercise.service;

import it.epicode.W6_D1_BE_Exercise.dto.LoginDto;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.model.User;
import it.epicode.W6_D1_BE_Exercise.repository.UserRepository;
import it.epicode.W6_D1_BE_Exercise.security.JwtTool;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTool jwtTool;

    public String login(LoginDto loginDto) throws NotFoundException{
       User user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new NotFoundException("Email/Password non trovati"));
       if (user.getPassword().equals(loginDto.getPassword())){
           return jwtTool.createToken(user);
       } else {
           throw new NotFoundException("Email/Password non trovati");
       }
    }
}
