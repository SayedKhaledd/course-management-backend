package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.dto.search.UserSearchDto;
import com.example.coursemanagementapp.service.UserService;
import jakarta.validation.Valid;
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
    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<UserDto>> findPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<UserSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }


    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PostMapping
    public ApiResponse<UserDto> createUser(@Validated(UserDto.Create.class) @RequestBody UserDto userDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(userDto));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PatchMapping("/{id}/role")
    public ApiResponse<?> updateRole(@PathVariable Long id, @RequestBody @Validated(UserDto.UpdateRole.class) UserDto userDto) {
        getService().updateRole(id, userDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PatchMapping("/{id}/first-name")
    public ApiResponse<?> updateFirstName(@PathVariable Long id, @RequestBody @Validated(UserDto.UpdateFirstName.class) UserDto userDto) {
        getService().updateFirstName(id, userDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PatchMapping("/{id}/last-name")
    public ApiResponse<?> updateLastName(@PathVariable Long id, @RequestBody @Validated(UserDto.UpdateLastName.class) UserDto userDto) {
        getService().updateLastName(id, userDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PatchMapping("/{id}/email")
    public ApiResponse<?> updateEmail(@PathVariable Long id, @RequestBody @Validated(UserDto.UpdateEmail.class) UserDto userDto) {
        getService().updateEmail(id, userDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @PatchMapping("/{id}/phone-number")
    public ApiResponse<?> updatePhoneNumber(@PathVariable Long id, @RequestBody @Validated(UserDto.UpdatePhoneNumber.class) UserDto userDto) {
        getService().updatePhoneNumber(id, userDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }
}
