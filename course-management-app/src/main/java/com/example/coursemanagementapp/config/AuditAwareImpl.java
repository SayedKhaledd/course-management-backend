package com.example.coursemanagementapp.config;

import com.example.keycloakbackendclient.dto.KeycloakUserDto;
import com.example.keycloakbackendclient.service.KeycloakUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Primary
@AllArgsConstructor
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    private final KeycloakUserService keycloakUserService;


    @Override
    public Optional<String> getCurrentAuditor() {
        KeycloakUserDto currentUser = keycloakUserService.getCurrentUser();
        return Optional.of(currentUser.getFirstName() + currentUser.getLastName());
    }

}

