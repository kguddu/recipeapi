package com.RecipeSelectionTest.RecipeSelectionApi.s.exception;

import com.RecipeSelectionTest.RecipeSelectionApi.s.entity.Error;

public class IdNotFoundException extends RuntimeException{
    public IdNotFoundException(String message) {
        super(message);
    }
}
