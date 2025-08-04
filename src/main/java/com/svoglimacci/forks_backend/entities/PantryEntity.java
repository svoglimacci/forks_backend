package com.svoglimacci.forks_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pantries")
public class PantryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @OneToOne
  @JoinColumn(name = "user_id", unique = true)
  private UserEntity user;

  @ManyToMany
  @JoinTable(
      name = "pantry_ingredients",
      joinColumns = @JoinColumn(name = "pantry_id"),
      inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
  private Set<IngredientEntity> ingredients = new HashSet<>();

  public PantryEntity() {}

  public PantryEntity(UserEntity user, Set<IngredientEntity> ingredients) {
    this.user = user;
    this.ingredients = ingredients;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public Set<IngredientEntity> getIngredients() {
    return ingredients;
  }

  public void setIngredients(Set<IngredientEntity> ingredients) {
    this.ingredients = ingredients;
  }
}
