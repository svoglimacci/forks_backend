package com.svoglimacci.forks_backend.configs;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseConfig {

  @Bean
  @Primary
  public DataSource backendDataSource(@Value("${app.datasource.backend.url}") String url,
      @Value("${app.datasource.backend.username}") String username,
      @Value("${app.datasource.backend.password}") String password) {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(url);
    config.setUsername(username);
    config.setPassword(password);
    return new HikariDataSource(config);
  }

  @Bean
  public DataSource keycloakDataSource(@Value("${app.datasource.keycloak.url}") String url,
      @Value("${app.datasource.keycloak.username}") String username,
      @Value("${app.datasource.keycloak.password}") String password) {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(url);
    config.setUsername(username);
    config.setPassword(password);
    return new HikariDataSource(config);
  }

  // Flyway configurations
  @Bean
  @Primary
  public Flyway backendFlyway(@Qualifier("backendDataSource") DataSource dataSource) {
    return Flyway.configure()
        .dataSource(dataSource)
        .locations("classpath:db/migration")
        .load();
  }

}