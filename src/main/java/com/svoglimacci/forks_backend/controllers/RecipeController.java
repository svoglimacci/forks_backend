package com.svoglimacci.forks_backend.controllers;

import com.svoglimacci.forks_backend.dtos.RecipeDTO;
import com.svoglimacci.forks_backend.dtos.UserDTO;
import com.svoglimacci.forks_backend.services.RecipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("recipes")
@Tag(name = "Recipe", description = "API for managing Recipes")
public class RecipeController {

  private final RecipeService recipeService;

  public RecipeController(RecipeService recipeService) {
    this.recipeService = recipeService;
  }

  @GetMapping
  @Operation(
      summary = "Get all recipes by author ID",
      description = "Returns a list of all recipes created by the authenticated user")
  public ResponseEntity<List<RecipeDTO>> getAllRecipesByAuthorId(@AuthenticationPrincipal Jwt jwt) {
    List<RecipeDTO> recipes =
        recipeService.getAllRecipesByAuthorId(UUID.fromString(jwt.getSubject()));
    return ResponseEntity.ok().body(recipes);
  }

  @GetMapping("/{recipe_id}")
  @Operation(
      summary = "Get recipe by ID",
      description = "Returns a recipe by its unique identifier")
  public ResponseEntity<RecipeDTO> getRecipeById(@PathVariable Long recipe_id) {
    RecipeDTO recipe = recipeService.getRecipeById(recipe_id);
    return ResponseEntity.ok().body(recipe);
  }

  @PostMapping
  @Operation(
      summary = "Create a new recipe",
      description = "Creates a new recipe and returns the created recipe")
  public ResponseEntity<RecipeDTO> createRecipe(
      @RequestBody RecipeDTO input, @AuthenticationPrincipal Jwt jwt) {
    input.setAuthor(new UserDTO(UUID.fromString(jwt.getSubject()), jwt.getClaimAsString("email")));

    RecipeDTO createdRecipe = recipeService.createRecipe(input);
    return ResponseEntity.created(java.net.URI.create("/recipes/" + createdRecipe.getId()))
        .body(createdRecipe);
  }

  @Operation(
      summary = "Update an existing recipe",
      description = "Updates an existing recipe by its ID and returns the updated recipe")
  @PutMapping("/{recipe_id}")
  public ResponseEntity<RecipeDTO> updateRecipe(
      @PathVariable Long recipe_id, @RequestBody RecipeDTO input) {
    RecipeDTO updatedRecipe = recipeService.updateRecipe(recipe_id, input);
    return ResponseEntity.ok().body(updatedRecipe);
  }

  @Operation(
      summary = "Delete a recipe",
      description = "Deletes a recipe by its ID and returns a success message")
  @DeleteMapping("/{recipe_id}")
  public ResponseEntity<String> deleteRecipe(
      @PathVariable Long recipe_id, @AuthenticationPrincipal Jwt jwt) {
    recipeService.deleteRecipe(recipe_id, UUID.fromString(jwt.getSubject()));
    return ResponseEntity.ok().body("Recipe deleted successfully");
  }
}
