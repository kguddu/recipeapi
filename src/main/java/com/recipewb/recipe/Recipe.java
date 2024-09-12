package com.recipewb.recipe;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name="recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Making time is required")
    private String makingTime;
    @NotBlank(message = "Serves is required")
    private String serves;
    @NotBlank(message = "Ingredients are required")
    private String ingredients;
    @NotNull(message = "Cost is mandatory")
    @Pattern(regexp = "\\d+", message = "Cost should be a valid number")
    private String cost;
}
