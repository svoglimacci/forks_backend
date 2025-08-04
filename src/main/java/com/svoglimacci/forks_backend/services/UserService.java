package com.svoglimacci.forks_backend.services;

import com.svoglimacci.forks_backend.dtos.IngredientDTO;
import com.svoglimacci.forks_backend.dtos.RecipeDTO;
import com.svoglimacci.forks_backend.dtos.UserDTO;
import com.svoglimacci.forks_backend.entities.PantryEntity;
import com.svoglimacci.forks_backend.entities.UserEntity;
import com.svoglimacci.forks_backend.exceptions.ResourceNotFoundException;
import com.svoglimacci.forks_backend.mappers.IngredientMapper;
import com.svoglimacci.forks_backend.mappers.RecipeMapper;
import com.svoglimacci.forks_backend.mappers.UserMapper;
import com.svoglimacci.forks_backend.repositories.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserDTO findUserById(UUID userId) {
    UserEntity user = userRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

    return UserMapper.toDTO(user);
  }

  public UserDTO createUser(UserDTO input) {
    UserEntity user = UserMapper.toModel(input);

    PantryEntity pantry = new PantryEntity();
    pantry.setUser(user);
    user.setPantry(pantry);

    UserEntity savedUser = userRepository.save(user);
    return UserMapper.toDTO(savedUser);
  }



}
