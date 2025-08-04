package com.svoglimacci.forks_backend.repositories;

import com.svoglimacci.forks_backend.entities.RecipeEntity;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {



  List<RecipeEntity> findAllByAuthorId(UUID authorId);
}

