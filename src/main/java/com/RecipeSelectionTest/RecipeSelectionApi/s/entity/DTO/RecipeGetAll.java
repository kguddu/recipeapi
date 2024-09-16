package com.RecipeSelectionTest.RecipeSelectionApi.s.entity.DTO;

import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecipeGetAll {
    private List<Recipe> recipes;
}
