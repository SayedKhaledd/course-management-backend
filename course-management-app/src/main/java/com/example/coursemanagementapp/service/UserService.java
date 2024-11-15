package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.UserDao;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.dto.search.UserSearchDto;
import com.example.coursemanagementapp.model.User;
import com.example.coursemanagementapp.transformer.UserTransformer;

public interface UserService extends AbstractService<User, UserDto, UserTransformer, UserDao> {

    PaginationResponse<UserDto> findAllPaginatedAndFiltered(PaginationRequest<UserSearchDto> paginationRequest);

    void updateRole(Long id, UserDto userDto);

    void updateFirstName(Long id, UserDto userDto);

    void updateLastName(Long id, UserDto userDto);

    void updateEmail(Long id, UserDto userDto);

    void updatePhoneNumber(Long id, UserDto userDto);
}
