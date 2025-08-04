package com.svoglimacci.forks_backend.repositories;

import com.svoglimacci.forks_backend.entities.PantryEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PantryRepository extends JpaRepository<PantryEntity, Long> {

  Optional<PantryEntity> findByUserId(UUID userId);
}
