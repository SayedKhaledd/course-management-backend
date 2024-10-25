package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController implements AbstractController<UserService, UserDto> {

    private final UserService userService;
    private final ApiResponseBuilder<UserDto> apiResponseBuilder;


    @Override
    public UserService getService() {
        return userService;
    }

    @Override
    public ApiResponseBuilder<UserDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

//    @PreAuthorize("hasAnyRole('SUPER_ADMIN', 'ADMIN')")
    @PostMapping
    public ApiResponse<UserDto> createUser(@Validated @RequestBody UserDto userDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(userDto));
    }


}
