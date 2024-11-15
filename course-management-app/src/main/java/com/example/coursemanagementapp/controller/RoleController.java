package com.example.coursemanagementapp.controller;


import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.enums.Role;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Validated
@RestController
@RequestMapping("/api/roles")
@AllArgsConstructor
public class RoleController {
    private final ApiResponseBuilder<UserDto> apiResponseBuilder;

    public ApiResponseBuilder<?> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @GetMapping("/all")
    public ApiResponse<?> findAll() {
        return getApiResponseBuilder().buildSuccessStringResponse(Arrays.stream(Role.values())
                .toList()
                .stream()
                .filter(role -> !role.equals(Role.SUPER_ADMIN))
                .map(Role::getRole)
                .toList());
    }
}
