package com.RecipeSelectionTest.RecipeSelectionApi.s.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is required")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotBlank(message = "Making time is required")
    @Column(name = "making_time", nullable = false, length = 100)
    private String makingTime;

    @NotBlank(message = "Serves is required")
    @Column(name = "serves", nullable = false, length = 100)
    private String serves;

    @NotBlank(message = "Ingredients are required")
    @Column(name = "ingredients", nullable = false, length = 300)
    private String ingredients;

    @NotNull(message = "Cost is required")
    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
