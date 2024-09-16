package com.RecipeSelectionTest.RecipeSelectionApi.s.controller;

import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.DTO.RecipeRequest;
import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Recipe;
import com.RecipeSelectionTest.RecipeSelectionApi.s.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public ResponseEntity addRecipe(@Valid @RequestBody RecipeRequest recipeRequest, BindingResult bindingResult) {
        return recipeService.addRecipe(recipeRequest, bindingResult);
    }

    @GetMapping
    public ResponseEntity getAllRecipes() {
        return recipeService.getRecipe();
    }

    @GetMapping("{id}")
    public ResponseEntity getRecipeById(@PathVariable int id) {
        return recipeService.getRecipeById(id);
    }

    @PatchMapping("{id}")
    public ResponseEntity updateRecipe(@PathVariable int id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRecipe(@PathVariable int id) {
        return recipeService.deleteRecipe(id);
    }
}
