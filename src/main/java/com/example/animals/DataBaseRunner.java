package com.example.animals;

import com.example.animals.model.Animal;
import com.example.animals.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataBaseRunner implements CommandLineRunner {

    private final AnimalRepository animalRepository;

    @Override
    public void run(String... args) {
        animalRepository.save(new Animal(1L, "Tiger", 100, 150, "mammal"));
        animalRepository.save(new Animal(2L, "Cobra", 10, 15, "reptile"));
        animalRepository.save(new Animal(3L, "T-rex", 50000, 100, "Dinosaurs"));
        animalRepository.save(new Animal(4L, "Cat", 40, 15, "mammal"));
        animalRepository.save(new Animal(5L, "Tarantula", 1, 1, "Spider"));
    }
}

