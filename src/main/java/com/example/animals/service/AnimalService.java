package com.example.animals.service;


import com.example.animals.exception.AnimalNotFoundException;
import com.example.animals.mapper.AnimalMapper;
import com.example.animals.model.Animal;
import com.example.animals.model.AnimalRequest;
import com.example.animals.model.AnimalResponse;
import com.example.animals.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnimalService {

    private static final String ANIMAL_IS_NOT_FOUND = "Animal is not found";

    private final AnimalRepository animalRepository;
    private final AnimalMapper animalMapper;


    public List<AnimalResponse> getAllAnimals() {
        return animalRepository.findAll().stream()
                .map(animalMapper::mapToAnimalResponse)
                .collect(Collectors.toList());
    }

    public AnimalResponse saveNewAnimal(AnimalRequest animalRequest) {
        log.info("User saving new animal.");
        Animal animal = animalRepository.save(animalMapper.mapToAnimal(animalRequest));
        return animalMapper.mapToAnimalResponse(animal);
    }

    public void deleteAnimal(Long id) {
        log.info("User deleting animal with: " + id);
        if (!isAnimalExist(id)) {
            throw new AnimalNotFoundException(ANIMAL_IS_NOT_FOUND);
        }
        animalRepository.deleteById(id);
    }

    public AnimalResponse updateAnimal(Long id, AnimalRequest animalRequest) {
        log.info("User updating animal with: " + id);

        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(ANIMAL_IS_NOT_FOUND));
        animal.setName(animalRequest.getName());
        animal.setHeight(animalRequest.getHeight());
        animal.setWeight(animalRequest.getWeight());
        animal.setAnimalClass(animalRequest.getAnimalClass());
        return animalMapper.mapToAnimalResponse(animalRepository.save(animal));
    }

    private boolean isAnimalExist(Long id) {
        return animalRepository.existsById(id);
    }
}

