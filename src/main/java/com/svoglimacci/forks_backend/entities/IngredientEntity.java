package com.svoglimacci.forks_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ingredients")
public class IngredientEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @ManyToMany(mappedBy = "ingredients")
  private List<RecipeEntity> recipes = new ArrayList<>();

  @ManyToMany(mappedBy = "ingredients")
  private Set<PantryEntity> pantries = new HashSet<>();

  public IngredientEntity(
      long id, String name, List<RecipeEntity> recipes, Set<PantryEntity> pantries) {
    this.id = id;
    this.name = name;
    this.recipes = recipes;
    this.pantries = pantries;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<RecipeEntity> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<RecipeEntity> recipes) {
    this.recipes = recipes;
  }

  public Set<PantryEntity> getPantries() {
    return pantries;
  }

  public void setPantries(Set<PantryEntity> pantries) {
    this.pantries = pantries;
  }

  public IngredientEntity() {}
}
