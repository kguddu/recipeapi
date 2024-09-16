package com.RecipeSelectionTest.RecipeSelectionApi.s.constants;

public enum Message {
    CREATED_SUCCESSFULLY("Recipe successfully created!"),
    CREATION_FAILED("Recipe creation failed!"),
    ID_NOT_FOUND("Recipe with the given id does not exist"),
    RECIPE_FOUND("Recipe details by the id"),
    UPDATED_SUCCESSFULLY("Recipe updated successfully"),
    DELETED_SUCCESSFULLY("Recipe deleted successfully");

    private final String message;

    // Constructor
    Message(String message) {
        this.message = message;
    }

    // Getter for the message
    public String getMessage() {
        return message;
    }
}