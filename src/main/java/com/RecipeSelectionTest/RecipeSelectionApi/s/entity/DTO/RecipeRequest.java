package com.RecipeSelectionTest.RecipeSelectionApi.s.entity.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class RecipeRequest {
    @NotBlank(message = "Title must not be null.")
    @NotNull
    private String title;
    @NotBlank(message = "MakingTime must not be null.")
    @NotNull
    private String makingTime;
    @NotBlank(message = "Serves must not be null.")
    @NotNull
    private String serves;
    @NotBlank(message = "Ingredients must not be null.")
    @NotNull
    private String ingredients;
    @NotNull
    private Integer cost;
}
