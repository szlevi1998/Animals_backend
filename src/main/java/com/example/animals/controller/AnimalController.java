package com.example.animals.controller;

import com.example.animals.model.AnimalRequest;
import com.example.animals.model.AnimalResponse;
import com.example.animals.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/animal")
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping
    public List<AnimalResponse> allAnimals() {
        return animalService.getAllAnimals();
    }

    @PostMapping
    public AnimalResponse setNewAnimal(@RequestBody AnimalRequest animalRequest) {
        return animalService.saveNewAnimal(animalRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Long id) {
        animalService.deleteAnimal(id);
    }

    @PutMapping("/{id}")
    public AnimalResponse updateAnimal(@PathVariable Long id, @RequestBody AnimalRequest animalRequest) {
        return animalService.updateAnimal(id, animalRequest);
    }
}
