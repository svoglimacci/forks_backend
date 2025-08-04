package com.svoglimacci.forks_backend.repositories;

import com.svoglimacci.forks_backend.entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {

}

