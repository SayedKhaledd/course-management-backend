package com.example.coursemanagementapp.validator;

import com.example.coursemanagementapp.enums.Role;
import com.example.keycloakbackendclient.service.KeycloakUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class UserValidatorImpl implements UserValidator {
    private final KeycloakUserService keycloakUserService;

    @Override
    public Boolean shouldUpdateRole(Role userRoleToUpdate) {
        List<String> roles = Arrays.stream(Role.values()).toList().stream().map(Role::getRole).toList();
        Role currentUserRole =
                Role.valueOf(keycloakUserService.getCurrentUser()
                        .getRoles()
                        .stream()
                        .filter(roles::contains)
                        .findFirst()
                        .orElse(null));
        return !userRoleToUpdate.equals(Role.SUPER_ADMIN) || currentUserRole.equals(Role.SUPER_ADMIN);
    }
}
