package com.svoglimacci.forks_backend.repositories;

import com.svoglimacci.forks_backend.dtos.UserDTO;
import com.svoglimacci.forks_backend.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> { }
