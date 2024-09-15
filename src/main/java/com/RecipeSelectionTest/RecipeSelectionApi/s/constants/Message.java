package com.RecipeSelectionTest.RecipeSelectionApi.s.constants;

public enum Message {
    CREATED_SUCCESSFULLY("Recipe created successfully"),
    CREATION_FAILED("Recipe cannot be added"),
    ID_NOT_FOUND("Recipe with the given id does not exist"),
    RECIPE_FOUND("Recipe details by the id : %d"),
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
    public String getMessageWithId(Integer id) {
        return String.format(this.message, id);
    }
}