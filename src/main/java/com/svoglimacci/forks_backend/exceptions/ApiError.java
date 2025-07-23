package com.svoglimacci.forks_backend.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class ApiError {
  private LocalDateTime timestamp;
  private String error;
  private HttpStatus status;

  public ApiError() {
    this.timestamp = LocalDateTime.now();
  }

  public ApiError(String error, HttpStatus status) {
    this.timestamp = LocalDateTime.now();
    this.error = error;
    this.status = status;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }
}
