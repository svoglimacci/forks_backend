package com.svoglimacci.forks_backend.configs;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig {
  @Bean
  SecurityFilterChain configureSecurityFilterChain(HttpSecurity http) throws Exception
  {
    http

        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .requestMatchers("/v3/api-docs/**").permitAll()
        .requestMatchers("/**").authenticated()
.anyRequest().authenticated())
.oauth2ResourceServer(it -> it.jwt(Customizer.withDefaults()))
        .cors(cors -> cors.configurationSource(corsConfigurationSource()));
    
    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(List.of("http://localhost:5173"));
    corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setAllowedHeaders(List.of("*"));
    corsConfiguration.setMaxAge(3600L);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);
    return source;
  }
}