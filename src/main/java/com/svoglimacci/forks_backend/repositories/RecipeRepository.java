package com.svoglimacci.forks_backend.repositories;

import com.svoglimacci.forks_backend.entities.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {}
