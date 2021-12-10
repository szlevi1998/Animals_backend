package com.example.animals.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AnimalExceptionHandler {
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(AnimalNotFoundException.class)
    public String handleAnimalNotFoundException(AnimalNotFoundException animalNotFoundException){
        log.error("{}",animalNotFoundException.getMessage());
        return animalNotFoundException.getMessage();
    }
}
