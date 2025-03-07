package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.model.User;
import com.example.coursemanagementapp.transformer.mapper.UserMapper;
import com.example.keycloakbackendclient.dto.KeycloakUserDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserTransformer implements AbstractTransformer<User, UserDto, UserMapper> {

    private final UserMapper userMapper;

    @Override
    public UserMapper getMapper() {
        return userMapper;
    }

    public KeycloakUserDto toKeycloakUserDto(UserDto user) {
        return getMapper().toKeycloakUserDto(user);
    }

    public UserDto toUserDto(KeycloakUserDto keycloakUserDto) {
        return getMapper().toUserDto(keycloakUserDto);
    }


}
