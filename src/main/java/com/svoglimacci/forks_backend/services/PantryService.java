package com.svoglimacci.forks_backend.services;

import com.svoglimacci.forks_backend.dtos.PantryDTO;
import com.svoglimacci.forks_backend.entities.PantryEntity;
import com.svoglimacci.forks_backend.exceptions.ResourceNotFoundException;
import com.svoglimacci.forks_backend.mappers.IngredientMapper;
import com.svoglimacci.forks_backend.mappers.PantryMapper;
import com.svoglimacci.forks_backend.repositories.PantryRepository;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class PantryService {

  private final PantryRepository pantryRepository;

  public PantryService(PantryRepository pantryRepository) {
    this.pantryRepository = pantryRepository;
  }

  public PantryDTO getPantryByUserId(UUID userId) {

    PantryEntity pantry = pantryRepository.findByUserId(userId)
        .orElseThrow(() -> new ResourceNotFoundException("Pantry not found for user: " + userId));

    return PantryMapper.toDTO(pantry);
  }


  public PantryDTO updatePantry(UUID uuid, PantryDTO input) {
    PantryEntity existingPantry = pantryRepository.findByUserId(uuid)
        .orElseThrow(() -> new ResourceNotFoundException("Pantry not found for user: " + uuid));

    existingPantry.setIngredients(
        input.getIngredients().stream()
            .map(IngredientMapper::toModel)
            .collect(Collectors.toSet())
    );

    PantryEntity updatedPantry = pantryRepository.save(existingPantry);
    return PantryMapper.toDTO(updatedPantry);
  }
}
