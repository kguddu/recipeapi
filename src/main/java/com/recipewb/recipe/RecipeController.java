package com.recipewb.recipe;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/recipes")
public class RecipeController {


        @Autowired
        private RecipeService recipeService;

        // Get all recipes
        @GetMapping
        public List<Recipe> getAllRecipes() {
            return recipeService.getAllRecipes();
        }

        // Get a single recipe by ID
        @GetMapping("/{id}")
        public ResponseEntity<Recipe> getRecipeById(@PathVariable Integer id) {
            Recipe recipe = recipeService.getRecipeById(id);
            //return recipe != null ? ResponseEntity.ok(recipe) : ResponseEntity.notFound().build();
            return ResponseEntity.ok(recipe);
        }

        // Create a new recipe
        @PostMapping
        public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody Recipe recipe) {
            Recipe savedRecipe = recipeService.createRecipe(recipe);
            return ResponseEntity.ok(savedRecipe);
        }

       // public Recipe createRecipe(@RequestBody Recipe recipe) {
            //return recipeService.createRecipe(recipe);
      //  }

        // Update a recipe by ID

        //@PutMapping("/{id}")
//        public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @RequestBody Recipe recipeDetails) {
//            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
//            return updatedRecipe != null ? ResponseEntity.ok(updatedRecipe) : ResponseEntity.notFound().build();
//        }

        @PutMapping("/{id}")
        public ResponseEntity<Recipe> updateRecipe(@PathVariable Integer id, @Valid @RequestBody Recipe recipeDetails) {
            Recipe updatedRecipe = recipeService.updateRecipe(id, recipeDetails);
            return ResponseEntity.ok(updatedRecipe);
        }

        // Delete a recipe by ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRecipe(@PathVariable Integer id) {
            recipeService.deleteRecipe(id);
            return ResponseEntity.noContent().build();
        }
    }


