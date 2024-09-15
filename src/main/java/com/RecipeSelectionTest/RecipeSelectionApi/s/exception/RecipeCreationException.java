package com.RecipeSelectionTest.RecipeSelectionApi.s.exception;

public class RecipeCreationException extends RuntimeException {
    public RecipeCreationException(Error error) {
        super(error);
    }

    public RecipeCreationException(String message) {
        super(message);
    }
}