package com.svoglimacci.forks_backend.mappers;

import com.svoglimacci.forks_backend.dtos.RecipeDTO;
import com.svoglimacci.forks_backend.entities.RecipeEntity;

public class RecipeMapper {
  public static RecipeDTO toDTO(RecipeEntity recipe) {
    RecipeDTO recipeDTO = new RecipeDTO();
    recipeDTO.setId(recipe.getId());
    recipeDTO.setTitle(recipe.getTitle());
    recipeDTO.setDescription(recipe.getDescription());

    return recipeDTO;
  }

  public static RecipeEntity toModel(RecipeDTO recipeDTO) {
    RecipeEntity recipe = new RecipeEntity();
    recipe.setId(recipeDTO.getId());
    recipe.setTitle(recipeDTO.getTitle());
    recipe.setDescription(recipeDTO.getDescription());

    return recipe;
  }
}
