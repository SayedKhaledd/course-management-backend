package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.UserRepo;
import com.example.coursemanagementapp.model.User;

public interface UserDao extends AbstractDao<User, UserRepo> {

}
