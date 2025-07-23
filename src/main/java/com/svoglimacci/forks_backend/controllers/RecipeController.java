package com.svoglimacci.forks_backend.controllers;

import com.svoglimacci.forks_backend.dtos.RecipeDTO;
import com.svoglimacci.forks_backend.services.RecipeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recipes")
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping
  public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
    List<RecipeDTO> recipes = recipeService.getAllRecipes();
    return ResponseEntity.ok().body(recipes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long id) {
    RecipeDTO recipe = recipeService.getRecipeById(id);
    return ResponseEntity.ok().body(recipe);
  }

  @PostMapping
  public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO input) {
    RecipeDTO createdRecipe = recipeService.createRecipe(input);
    return ResponseEntity.ok().body(createdRecipe);
  }

  @PutMapping("/{id}")
  public ResponseEntity<RecipeDTO> updateRecipe(
      @PathVariable Long id, @RequestBody RecipeDTO input) {
    RecipeDTO updatedRecipe = recipeService.updateRecipe(id, input);
    return ResponseEntity.ok().body(updatedRecipe);
  }
}
