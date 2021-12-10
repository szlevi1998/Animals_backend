package com.example.animals.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class AnimalResponse {
    private Long id;
    private String name;
    private int height;
    private int weight;
    private String animalClass;
}
