package com.svoglimacci.forks_backend.dtos;

import java.util.Set;

public class PantryDTO {

  public PantryDTO() {}

  public PantryDTO(long id, UserDTO user, Set<IngredientDTO> ingredients) {
    this.id = id;
    this.user = user;
    this.ingredients = ingredients;
  }

  private long id;
  private UserDTO user;
  private Set<IngredientDTO> ingredients;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public UserDTO getUser() {
    return user;
  }

  public void setUser(UserDTO user) {
    this.user = user;
  }

  public Set<IngredientDTO> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<IngredientDTO> ingredients) {
    this.ingredients = ingredients;
  }
}
