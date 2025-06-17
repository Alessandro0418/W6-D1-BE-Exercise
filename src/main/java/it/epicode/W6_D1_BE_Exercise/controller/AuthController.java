package it.epicode.W6_D1_BE_Exercise.controller;

import it.epicode.W6_D1_BE_Exercise.dto.LoginDto;
import it.epicode.W6_D1_BE_Exercise.dto.UserDto;
import it.epicode.W6_D1_BE_Exercise.exeption.NotFoundException;
import it.epicode.W6_D1_BE_Exercise.exeption.ValidationExeption;
import it.epicode.W6_D1_BE_Exercise.model.User;
import it.epicode.W6_D1_BE_Exercise.service.AuthService;
import it.epicode.W6_D1_BE_Exercise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/register")
    public User register(@RequestBody @Validated UserDto userDto, BindingResult bindingResult) throws ValidationExeption {
        if (bindingResult.hasErrors()) {
            throw new ValidationExeption(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, e) -> s + e));
        }
        return userService.saveUser(userDto);
    }


    @GetMapping("/auth/login")
    public String login(@RequestBody @Validated LoginDto loginDto, BindingResult bindingResult) throws ValidationExeption, NotFoundException {

        if (bindingResult.hasErrors()) {
            throw new ValidationExeption(bindingResult.getAllErrors().stream()
                    .map(objectError -> objectError.getDefaultMessage())
                    .reduce("", (s, e) -> s + e));

        }
        return authService.login(loginDto);

    }
}
