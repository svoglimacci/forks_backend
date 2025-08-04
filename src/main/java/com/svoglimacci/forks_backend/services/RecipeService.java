package com.svoglimacci.forks_backend.services;

import com.svoglimacci.forks_backend.dtos.RecipeDTO;
import com.svoglimacci.forks_backend.entities.RecipeEntity;
import com.svoglimacci.forks_backend.exceptions.ResourceNotFoundException;
import com.svoglimacci.forks_backend.mappers.IngredientMapper;
import com.svoglimacci.forks_backend.mappers.RecipeMapper;
import com.svoglimacci.forks_backend.repositories.RecipeRepository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

  private final RecipeRepository recipeRepository;

  public RecipeService(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  public List<RecipeDTO> getAllRecipesByAuthorId(UUID authorId) {
    List<RecipeEntity> recipes = recipeRepository.findAllByAuthorId(authorId);

    return recipes.stream().map(RecipeMapper::toDTO).collect(Collectors.toList());
  }

  public RecipeDTO getRecipeById(long id) {
    RecipeEntity recipe =
        recipeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));

    return RecipeMapper.toDTO(recipe);
  }

  public RecipeDTO createRecipe(RecipeDTO input) {
    RecipeEntity recipe = RecipeMapper.toModel(input);
    RecipeEntity savedRecipe = recipeRepository.save(recipe);
    return RecipeMapper.toDTO(savedRecipe);
  }

  public RecipeDTO updateRecipe(long id, RecipeDTO input) {
    RecipeEntity existingRecipe =
        recipeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));
    if (!existingRecipe.getAuthor().getId().equals(input.getAuthor().getId())) {
      throw new ResourceNotFoundException("Recipe not found with id: " + id);
    }

    existingRecipe.setTitle(input.getTitle());
    existingRecipe.setDescription(input.getDescription());
    existingRecipe.setIngredients(
        input.getIngredients().stream().map(IngredientMapper::toModel).collect(Collectors.toSet()));

    RecipeEntity updatedRecipe = recipeRepository.save(existingRecipe);
    return RecipeMapper.toDTO(updatedRecipe);
  }

  public void deleteRecipe(long id, UUID uuid) {

    RecipeEntity recipe =
        recipeRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with id: " + id));
    if (!recipe.getAuthor().getId().equals(uuid)) {
      throw new ResourceNotFoundException("Recipe not found with id: " + id);
    }

    recipeRepository.deleteById(id);
  }
}
