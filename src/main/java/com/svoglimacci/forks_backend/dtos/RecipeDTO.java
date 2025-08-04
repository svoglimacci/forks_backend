package com.svoglimacci.forks_backend.dtos;

import java.util.Set;

public class RecipeDTO {

  public RecipeDTO() {}

  public RecipeDTO(
      long id, String title, String description, UserDTO author, Set<IngredientDTO> ingredients) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.author = author;
    this.ingredients = ingredients;
  }

  private long id;
  private String title;
  private String description;
  private UserDTO author;
  private Set<IngredientDTO> ingredients;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public UserDTO getAuthor() {
    return author;
  }

  public void setAuthor(UserDTO author) {
    this.author = author;
  }

  public Set<IngredientDTO> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<IngredientDTO> ingredients) {
    this.ingredients = ingredients;
  }
}
