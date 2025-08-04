package com.svoglimacci.forks_backend.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class UserEntity {

  @Id
  private UUID id;
  private String email;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private PantryEntity pantry;

  @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
  private List<RecipeEntity> recipes = new ArrayList<>();

  public UserEntity() {}

  public UserEntity(UUID id, String email, PantryEntity pantry, List<RecipeEntity> recipes) {
    this.id = id;
    this.email = email;
    this.pantry = pantry;
    this.recipes = recipes;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PantryEntity getPantry() {
    return pantry;
  }

  public void setPantry(PantryEntity pantry) {
    this.pantry = pantry;
  }

  public List<RecipeEntity> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<RecipeEntity> recipes) {
    this.recipes = recipes;
  }

}
