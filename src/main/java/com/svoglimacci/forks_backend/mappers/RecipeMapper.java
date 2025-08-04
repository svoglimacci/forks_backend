package com.svoglimacci.forks_backend.mappers;

import com.svoglimacci.forks_backend.dtos.RecipeDTO;
import com.svoglimacci.forks_backend.entities.RecipeEntity;
import java.util.stream.Collectors;

public class RecipeMapper {
  public static RecipeDTO toDTO(RecipeEntity recipe) {
    RecipeDTO recipeDTO = new RecipeDTO();
    recipeDTO.setId(recipe.getId());
    recipeDTO.setTitle(recipe.getTitle());
    recipeDTO.setDescription(recipe.getDescription());
    recipeDTO.setAuthor(UserMapper.toDTO(recipe.getAuthor()));

    recipeDTO.setIngredients(
        recipe.getIngredients().stream().map(IngredientMapper::toDTO).collect(Collectors.toSet()));

    return recipeDTO;
  }

  public static RecipeEntity toModel(RecipeDTO recipeDTO) {
    RecipeEntity recipe = new RecipeEntity();
    recipe.setId(recipeDTO.getId());
    recipe.setTitle(recipeDTO.getTitle());
    recipe.setDescription(recipeDTO.getDescription());
    recipe.setAuthor(UserMapper.toModel(recipeDTO.getAuthor()));

    recipe.setIngredients(
        recipeDTO.getIngredients().stream()
            .map(IngredientMapper::toModel)
            .collect(Collectors.toSet()));

    return recipe;
  }
}
