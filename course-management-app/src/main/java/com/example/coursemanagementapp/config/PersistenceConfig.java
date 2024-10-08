package com.example.coursemanagementapp.config;


import com.example.keycloakbackendclient.dto.KeycloakUserDto;
import com.example.keycloakbackendclient.service.KeycloakUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@AllArgsConstructor
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class PersistenceConfig {
    private final KeycloakUserService keycloakUserService;

    @Bean
    public AuditAwareImpl auditorProvider() {
        return new AuditAwareImpl(keycloakUserService);
    }
}
