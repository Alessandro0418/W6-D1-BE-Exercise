package it.epicode.W6_D1_BE_Exercise.exeption;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
