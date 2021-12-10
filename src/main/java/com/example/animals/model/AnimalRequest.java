package com.example.animals.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalRequest {
    @NotBlank
    private String name;
    @Min(0)
    private int height;
    @Min(0)
    private int weight;
    @NotBlank
    private String animalClass;
}
