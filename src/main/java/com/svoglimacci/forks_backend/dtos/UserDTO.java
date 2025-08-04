package com.svoglimacci.forks_backend.dtos;

import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

public class UserDTO {

  public UserDTO() {
  }

  public UserDTO(UUID id, String email) {
    this.id = id;
    this.email = email;
  }


  private UUID id;
  private String email;


  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}
