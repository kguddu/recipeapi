package com.RecipeSelectionTest.RecipeSelectionApi.s.entity.DTO;

import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {
    private String message;
    private List<Recipe> recipes;
}
