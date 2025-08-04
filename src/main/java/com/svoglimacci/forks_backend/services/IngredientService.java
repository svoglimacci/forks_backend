package com.svoglimacci.forks_backend.services;

import com.svoglimacci.forks_backend.dtos.IngredientDTO;
import com.svoglimacci.forks_backend.entities.IngredientEntity;
import com.svoglimacci.forks_backend.exceptions.ResourceNotFoundException;
import com.svoglimacci.forks_backend.mappers.IngredientMapper;
import com.svoglimacci.forks_backend.repositories.IngredientRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

  private final IngredientRepository ingredientRepository;

  public IngredientService(IngredientRepository ingredientRepository) {
    this.ingredientRepository = ingredientRepository;
  }

  public List<IngredientDTO> getAllIngredients() {
    return ingredientRepository.findAll().stream()
        .map(IngredientMapper::toDTO)
        .toList();
  }

  public IngredientDTO getIngredientById(long id) {
    IngredientEntity ingredient =
        ingredientRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id: " + id));

    return IngredientMapper.toDTO(ingredient);
}


  public IngredientDTO createIngredient(IngredientDTO input) {
    IngredientEntity ingredient = IngredientMapper.toModel(input);
    IngredientEntity savedIngredient = ingredientRepository.save(ingredient);
    return IngredientMapper.toDTO(savedIngredient);
  }

  public IngredientDTO updateIngredient(long id, IngredientDTO input) {
    IngredientEntity existingIngredient =
        ingredientRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found with id: " + id));

    existingIngredient.setName(input.getName());

    IngredientEntity updatedIngredient = ingredientRepository.save(existingIngredient);
    return IngredientMapper.toDTO(updatedIngredient);
  }

  public void deleteIngredient(long id) {
    ingredientRepository.deleteById(id);
  }

}
