package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.UserDao;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.transformer.UserTransformer;
import com.example.keycloakbackendclient.dto.KeycloakUserDto;
import com.example.keycloakbackendclient.service.KeycloakUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserTransformer userTransformer;
    private final KeycloakUserService keycloakUserService;

    @Override
    public UserDao getDao() {
        return userDao;
    }

    @Override
    public UserTransformer getTransformer() {
        return userTransformer;
    }

    @Transactional
    @Override
    public UserDto create(UserDto dto) {
        log.info("UserService: create - was called with user: {}", dto);
        UserDto userDto = UserService.super.create(dto);
        KeycloakUserDto keycloakUserDto = getTransformer().toKeycloakUserDto(dto);
        keycloakUserDto.setId(userDto.getId() + "");
        return getTransformer().toUserDto(keycloakUserService.registerUser(keycloakUserDto));
    }
}
