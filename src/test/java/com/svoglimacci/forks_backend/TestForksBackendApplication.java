package com.svoglimacci.forks_backend;

import org.springframework.boot.SpringApplication;

public class TestForksBackendApplication {

  public static void main(String[] args) {
    SpringApplication.from(ForksBackendApplication::main)
        .with(TestcontainersConfiguration.class)
        .run(args);
  }
}
