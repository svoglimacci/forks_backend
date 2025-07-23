package com.svoglimacci.forks_backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String message) {
    super(message);
  }
}
