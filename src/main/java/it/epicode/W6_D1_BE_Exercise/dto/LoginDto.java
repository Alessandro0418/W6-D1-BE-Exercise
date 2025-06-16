package it.epicode.W6_D1_BE_Exercise.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDto {

    @Email(message = "L'email deve essere ben strutturata")
    @NotEmpty(message = "L'email non può essere vuota")
    private String email;

    @NotEmpty(message = "La password non può essere vuota")
    private String password;
}
