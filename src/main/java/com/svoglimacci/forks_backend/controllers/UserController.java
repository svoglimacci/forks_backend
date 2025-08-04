package com.svoglimacci.forks_backend.controllers;

import com.svoglimacci.forks_backend.dtos.UserDTO;
import com.svoglimacci.forks_backend.services.UserService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/me")
  public ResponseEntity<UserDTO> myself(@AuthenticationPrincipal Jwt jwt) {
    UserDTO user = userService.findUserById(UUID.fromString(jwt.getSubject()));

    return ResponseEntity.ok().body(user);
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(
      @AuthenticationPrincipal Jwt jwt, @RequestBody UserDTO input) {
    input.setEmail(jwt.getClaimAsString("email"));
    input.setId(UUID.fromString(jwt.getSubject()));
    UserDTO createdUser = userService.createUser(input);

    return ResponseEntity.ok().body(createdUser);
  }
}
