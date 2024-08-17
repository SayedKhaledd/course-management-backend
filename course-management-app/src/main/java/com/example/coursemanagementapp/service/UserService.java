package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.User;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.transformer.UserTransformer;
import com.example.coursemanagementapp.dao.UserDao;
import com.example.backendcoreservice.service.AbstractService;

public interface UserService extends AbstractService<User, UserDto, UserTransformer, UserDao> {

}
