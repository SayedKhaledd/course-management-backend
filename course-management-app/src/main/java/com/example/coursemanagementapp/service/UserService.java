package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.UserDao;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.model.User;
import com.example.coursemanagementapp.transformer.UserTransformer;

public interface UserService extends AbstractService<User, UserDto, UserTransformer, UserDao> {

}
