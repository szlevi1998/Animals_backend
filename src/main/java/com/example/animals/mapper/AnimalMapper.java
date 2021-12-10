package com.example.animals.mapper;

import com.example.animals.model.Animal;
import com.example.animals.model.AnimalRequest;
import com.example.animals.model.AnimalResponse;
import org.springframework.stereotype.Component;

@Component
public class AnimalMapper {
    public AnimalResponse mapToAnimalResponse(Animal animal) {
        return AnimalResponse.builder()
                .id(animal.getId())
                .name(animal.getName())
                .height(animal.getHeight())
                .weight(animal.getWeight())
                .animalClass(animal.getAnimalClass())
                .build();

    }

    public Animal mapToAnimal(AnimalRequest animalRequest) {
        return Animal.builder()
                .name(animalRequest.getName())
                .height(animalRequest.getHeight())
                .weight(animalRequest.getWeight())
                .animalClass(animalRequest.getAnimalClass())
                .build();

    }
}

