package com.svoglimacci.forks_backend.mappers;

import com.svoglimacci.forks_backend.dtos.PantryDTO;
import com.svoglimacci.forks_backend.entities.PantryEntity;

public class PantryMapper {
  public static PantryDTO toDTO(PantryEntity pantryEntity) {
    PantryDTO pantryDTO = new PantryDTO();
    pantryDTO.setId(pantryEntity.getId());
    pantryDTO.setUser(UserMapper.toDTO(pantryEntity.getUser()));
    pantryDTO.setIngredients(
        pantryEntity.getIngredients().stream()
            .map(IngredientMapper::toDTO)
            .collect(java.util.stream.Collectors.toSet()));
    return pantryDTO;
  }

  public static PantryEntity toModel(PantryDTO pantryDTO) {
    PantryEntity pantryEntity = new PantryEntity();
    pantryEntity.setId(pantryDTO.getId());
    pantryEntity.setUser(UserMapper.toModel(pantryDTO.getUser()));
    pantryEntity.setIngredients(
        pantryDTO.getIngredients().stream()
            .map(IngredientMapper::toModel)
            .collect(java.util.stream.Collectors.toSet()));
    return pantryEntity;
  }



}
