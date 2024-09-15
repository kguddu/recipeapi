package com.RecipeSelectionTest.RecipeSelectionApi.s.repository;

import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
