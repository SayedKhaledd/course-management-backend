package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


}
