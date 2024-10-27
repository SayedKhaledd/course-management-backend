package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.UserDao;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.model.User;
import com.example.coursemanagementapp.transformer.UserTransformer;

import java.util.List;

public interface UserService extends AbstractService<User, UserDto, UserTransformer, UserDao> {

    void updateUserRole(Long id, String role);
}
