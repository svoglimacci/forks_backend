package com.svoglimacci.forks_backend.repositories;

import com.svoglimacci.forks_backend.entities.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {}
