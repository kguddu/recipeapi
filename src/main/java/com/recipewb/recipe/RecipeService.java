package com.recipewb.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecipeService {

      @Autowired
        private RecipeRepository recipeRepository;

        public List<Recipe> getAllRecipes() {
            return recipeRepository.findAll();
        }

        public Recipe getRecipeById(Integer id) {
            //return recipeRepository.findById(id).orElse(null);
            return recipeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recipe id not found"));

        }

        public Recipe createRecipe(Recipe recipe) {
            return recipeRepository.save(recipe);
        }

        public Recipe updateRecipe(Integer id, Recipe recipeDetails) {
            //Recipe recipe = recipeRepository.findById(id).orElse(null);
//            if (recipe != null) {
//                recipe.setTitle(recipeDetails.getTitle());
//                recipe.setMakingTime(recipeDetails.getMakingTime());
//                recipe.setServes(recipeDetails.getServes());
//                recipe.setIngredients(recipeDetails.getIngredients());
//                recipe.setCost(recipeDetails.getCost());
//                return recipeRepository.save(recipe);
//            }
//            return null;
            Recipe recipe = recipeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recipe does not exist"));
            recipe.setTitle(recipeDetails.getTitle());
            recipe.setMakingTime(recipeDetails.getMakingTime());
            recipe.setServes(recipeDetails.getServes());
            recipe.setIngredients(recipeDetails.getIngredients());
            recipe.setCost(recipeDetails.getCost());

            return recipeRepository.save(recipe);
        }

        public void deleteRecipe(Integer id) {
            //recipeRepository.deleteById(id);
            Recipe recipe = recipeRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Recipe id not found"));
            recipeRepository.delete(recipe);
        }
    }


