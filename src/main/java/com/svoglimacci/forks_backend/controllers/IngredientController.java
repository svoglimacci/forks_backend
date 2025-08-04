package com.svoglimacci.forks_backend.controllers;

import com.svoglimacci.forks_backend.dtos.IngredientDTO;
import com.svoglimacci.forks_backend.services.IngredientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredients")
@Tag(name = "Ingredient", description = "API for managing Ingredients")
public class IngredientController {

  private final IngredientService ingredientService;

  public IngredientController(IngredientService ingredientService) { this.ingredientService = ingredientService; }

  @GetMapping
  @Operation(summary = "Get all ingredients", description = "Returns a list of all ingredients")
  public ResponseEntity<?> getAllIngredients() {
    List<IngredientDTO> ingredients = ingredientService.getAllIngredients();
    return ResponseEntity.ok().body(ingredients);
  }

  @GetMapping("/{ingredient_id}")
  @Operation(
      summary = "Get ingredient by ID",
      description = "Returns an ingredient by its unique identifier")
  public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable long ingredient_id) {
    IngredientDTO ingredient = ingredientService.getIngredientById(ingredient_id);
    return ResponseEntity.ok().body(ingredient);
  }

  @PostMapping
  @Operation(
      summary = "Create a new ingredient",
      description = "Creates a new ingredient and returns the created ingredient")
  public ResponseEntity<IngredientDTO> createIngredient(@RequestBody IngredientDTO input) {
    IngredientDTO createdIngredient = ingredientService.createIngredient(input);
    return ResponseEntity.ok().body(createdIngredient);
  }

  @PutMapping("/{ingredient_id}")
  @Operation(
      summary = "Update an existing ingredient",
      description = "Updates an existing ingredient by its ID and returns the updated ingredient")
  public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable long ingredient_id, @RequestBody IngredientDTO input) {
    IngredientDTO updatedIngredient = ingredientService.updateIngredient(ingredient_id, input);
    return ResponseEntity.ok().body(updatedIngredient);
  }

  @DeleteMapping("/{ingredient_id}")
  @Operation(
      summary = "Delete an ingredient",
      description = "Deletes an ingredient by its ID and returns a success message")
  public ResponseEntity<?> deleteIngredient(@PathVariable long ingredient_id) {
    ingredientService.deleteIngredient(ingredient_id);
    return ResponseEntity.ok().body(Map.of("message", "Ingredient deleted successfully"));
  }


}