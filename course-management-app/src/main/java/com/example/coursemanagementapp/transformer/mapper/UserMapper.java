package com.example.coursemanagementapp.transformer.mapper;

import com.example.backendcoreservice.transformer.mapper.AbstractMapper;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.enums.Role;
import com.example.coursemanagementapp.model.User;
import com.example.keycloakbackendclient.dto.KeycloakUserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDto> {

    @Mapping(target = "roles", expression = "java(roles(user))")
    @Mapping(target = "username", source = "email")
    KeycloakUserDto toKeycloakUserDto(UserDto user);

    @Mapping(target = "role", expression = "java(role(keycloakUserDto))")
    UserDto toUserDto(KeycloakUserDto keycloakUserDto);

    default List<String> roles(UserDto user) {
        return List.of(user.getRole().name());
    }

    default Role role(KeycloakUserDto keycloakUserDto) {
        return keycloakUserDto.getRoles() == null ? null :
                Role.valueOf(keycloakUserDto.getRoles().stream()
                        .filter(e -> !e.equals("default-roles-course-management")
                                && !e.equals("offline_access")
                                && !e.equals("uma_authorization"))
                        .findFirst().get());
    }

}
