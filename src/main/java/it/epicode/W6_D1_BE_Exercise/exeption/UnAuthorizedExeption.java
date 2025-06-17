package it.epicode.W6_D1_BE_Exercise.exeption;

public class UnAuthorizedExeption extends RuntimeException{
  public UnAuthorizedExeption(String message){
    super(message);
  }
}
