package com.svoglimacci.forks_backend.controllers;

import com.svoglimacci.forks_backend.dtos.PantryDTO;
import com.svoglimacci.forks_backend.services.PantryService;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pantry")
public class PantryController {

  private final PantryService pantryService;

  public PantryController(PantryService pantryService) {
    this.pantryService = pantryService;
  }

  @GetMapping
  public ResponseEntity<PantryDTO> getPantryByUserId(@AuthenticationPrincipal Jwt jwt) {

    PantryDTO pantry = pantryService.getPantryByUserId(UUID.fromString(jwt.getSubject()));
    return ResponseEntity.ok().body(pantry);
  }

  @PutMapping
  public ResponseEntity<PantryDTO> updatePantry(
      @AuthenticationPrincipal Jwt jwt, @RequestBody PantryDTO input) {
    PantryDTO updatedPantry = pantryService.updatePantry(UUID.fromString(jwt.getSubject()), input);

    return ResponseEntity.ok().body(updatedPantry);
  }
}
