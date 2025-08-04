package com.svoglimacci.forks_backend.mappers;

import com.svoglimacci.forks_backend.dtos.UserDTO;
import com.svoglimacci.forks_backend.entities.UserEntity;

public class UserMapper {
  public static UserDTO toDTO(UserEntity user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setId(user.getId());
    userDTO.setEmail(user.getEmail());

    return userDTO;
  }

  public static UserEntity toModel(UserDTO userDTO) {
    UserEntity user = new UserEntity();
    user.setId(userDTO.getId());
    user.setEmail(userDTO.getEmail());

    return user;
  }
}
