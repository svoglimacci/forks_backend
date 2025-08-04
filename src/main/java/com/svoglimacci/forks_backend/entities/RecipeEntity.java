package com.svoglimacci.forks_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "recipes")
public class RecipeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String description;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private UserEntity author;

  @ManyToMany()
  @JoinTable(
      name = "recipe_ingredient",
      joinColumns = @JoinColumn(name = "recipe_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
  private Set<IngredientEntity> ingredients = new HashSet<>();

  public RecipeEntity() {}

  public RecipeEntity(
      long id,
      String title,
      String description,
      Set<IngredientEntity> ingredients,
      UserEntity author) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.ingredients = ingredients;
    this.author = author;
  }

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

  public UserEntity getAuthor() {
    return author;
  }

  public void setAuthor(UserEntity author) {
    this.author = author;
  }

  public Set<IngredientEntity> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<IngredientEntity> ingredients) {
    this.ingredients = ingredients;
  }
}
