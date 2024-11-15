package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.UserRepo;
import com.example.coursemanagementapp.dto.search.UserSearchDto;
import com.example.coursemanagementapp.model.User;
import org.springframework.data.domain.Page;

public interface UserDao extends AbstractDao<User, UserRepo> {

    Page<User> findAllPaginatedAndFiltered(PaginationRequest<UserSearchDto> paginationRequest);

    void updateRole(Long id, String role);

    void updateFirstName(Long id, String firstName);

    void updateLastName(Long id, String lastName);

    void updateEmail(Long id, String email);

    void updatePhoneNumber(Long id, String phoneNumber);
}
