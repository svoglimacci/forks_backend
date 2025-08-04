package com.svoglimacci.forks_backend.mappers;

import com.svoglimacci.forks_backend.dtos.IngredientDTO;
import com.svoglimacci.forks_backend.entities.IngredientEntity;

public class IngredientMapper {
  public static IngredientDTO toDTO(IngredientEntity ingredient) {
    IngredientDTO ingredientDTO = new IngredientDTO();
    ingredientDTO.setId(ingredient.getId());
    ingredientDTO.setName(ingredient.getName());
    return ingredientDTO;
  }

  public static IngredientEntity toModel(IngredientDTO ingredientDTO) {
    IngredientEntity ingredient = new IngredientEntity();
    ingredient.setId(ingredientDTO.getId());
    ingredient.setName(ingredientDTO.getName());
    return ingredient;
  }

}
