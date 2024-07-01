package com.example.spazio.dto.modDTO;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class RatingModEntradaDTO {

    @NotNull(message = "El ID del rating no puede ser nulo")
    private Long id;

    @NotNull(message = "El valor del rating no puede ser nulo")
    @Min(value = 1, message = "El valor del rating debe ser al menos 1.0")
    @Max(value = 5, message = "El valor del rating debe ser como máximo 5.0")
    private Float rating;

    public RatingModEntradaDTO(Long id, Float rating) {
        this.id = id;
        this.rating = rating;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}