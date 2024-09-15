package com.RecipeSelectionTest.RecipeSelectionApi.s.service;

import com.RecipeSelectionTest.RecipeSelectionApi.s.constants.Message;
import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.DTO.RecipeRequest;
import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.DTO.RecipeResponse;
import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Error;
import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.ErrorMessage;
import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Recipe;
import com.RecipeSelectionTest.RecipeSelectionApi.s.exception.IdNotFoundException;
import com.RecipeSelectionTest.RecipeSelectionApi.s.exception.RecipeCreationException;
import com.RecipeSelectionTest.RecipeSelectionApi.s.repository.RecipeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public ResponseEntity addRecipe(RecipeRequest recipeRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return handleValidationErrors(bindingResult);
            }
        try {
            Recipe recipe = mapToRecipe(recipeRequest);
            recipeRepository.save(recipe);
            RecipeResponse recipeResponse = mapToRecipeResponse(recipe);
            recipeResponse.setMessage(Message.CREATED_SUCCESSFULLY.getMessage());
            return ResponseEntity.ok(recipeResponse);
        } catch (RuntimeException runtimeException) {
            Error error = new Error();
            error.setMessage(Message.CREATION_FAILED.getMessage());
                return ResponseEntity.badRequest().body(error);
            }
        }

    public ResponseEntity<List<Recipe>> getRecipe(){
        return ResponseEntity.ok(recipeRepository.findAll());
    }

    public ResponseEntity getRecipeById(Integer id) {
        if (recipeRepository.existsById(id)){
            Recipe recipe = recipeRepository.findById(id).get();
            RecipeResponse recipeResponse = mapToRecipeResponse(recipe);
            recipeResponse.setMessage(Message.RECIPE_FOUND.getMessageWithId(id));
            return ResponseEntity.ok(recipeResponse);
        } else {
            ErrorMessage error = new ErrorMessage(Message.ID_NOT_FOUND.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity updateRecipe(Integer id, Recipe recipe) {
        if (recipeRepository.existsById(id)) {
            Recipe getRecipe = recipeRepository.findById(id)
                    .orElseThrow(() -> new IdNotFoundException(Message.ID_NOT_FOUND.getMessage()));
            if(recipe.getTitle() != null)
                getRecipe.setTitle(recipe.getTitle());
            if(recipe.getMakingTime() != null)
                getRecipe.setMakingTime(recipe.getMakingTime());
            if(recipe.getCost() != null)
                getRecipe.setCost(recipe.getCost());
            if(recipe.getServes() != null)
                getRecipe.setServes(recipe.getServes());
            if(recipe.getServes() != null)
                getRecipe.setServes(recipe.getServes());
            if(recipe.getIngredients() != null)
                getRecipe.setIngredients(recipe.getIngredients());
            recipeRepository.save(getRecipe);
            RecipeResponse recipeResponse = mapToRecipeResponse(getRecipe);
            recipeResponse.setMessage(Message.UPDATED_SUCCESSFULLY.getMessage());
            return ResponseEntity.ok(recipeResponse);
        } else {
            ErrorMessage error = new ErrorMessage(Message.ID_NOT_FOUND.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity deleteRecipe(Integer id) {
        ErrorMessage error = new ErrorMessage();
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
            error.setMessage(Message.DELETED_SUCCESSFULLY.getMessage());
            return ResponseEntity.ok(error);
        } else {
            error.setMessage(Message.ID_NOT_FOUND.getMessage());
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    private Recipe mapToRecipe(RecipeRequest recipeRequest) {
        Recipe recipe = new Recipe();
        recipe.setTitle(recipeRequest.getTitle());
        recipe.setMakingTime(recipeRequest.getMakingTime());
        recipe.setServes(recipeRequest.getServes());
        recipe.setIngredients(recipeRequest.getIngredients());
        recipe.setCost(recipeRequest.getCost());
        return recipe;
    }

    private RecipeResponse mapToRecipeResponse(Recipe recipes) {
        RecipeResponse recipeResponse = new RecipeResponse();
        List<Recipe> recipesToAdd = new ArrayList<>();
        recipesToAdd.add(recipes);
        recipeResponse.setRecipes(recipesToAdd);
        return recipeResponse;
    }

    private ResponseEntity<Error> handleValidationErrors(BindingResult bindingResult) {
        Set<String> validationErrors = new HashSet<>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            validationErrors.add(error.getField());
        }
        Error errorResponse = new Error();
        errorResponse.setMessage("Validation failed");
        errorResponse.setStackTrace(validationErrors);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
