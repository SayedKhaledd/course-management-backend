package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @GetMapping("/all")
    public ApiResponse<List<UserDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PostMapping
    public ApiResponse<UserDto> createUser(@Validated @RequestBody UserDto userDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(userDto));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PutMapping("/{id}/role/{role}")
    public ApiResponse<?> updateUserRole(@PathVariable Long id, @PathVariable String role) {
        getService().updateUserRole(id, role);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
