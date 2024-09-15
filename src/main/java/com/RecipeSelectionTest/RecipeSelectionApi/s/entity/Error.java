package com.RecipeSelectionTest.RecipeSelectionApi.s.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private String message;
    private Set<String> stackTrace;

    public Error(String message) {
        this.message = message;
    }
}
