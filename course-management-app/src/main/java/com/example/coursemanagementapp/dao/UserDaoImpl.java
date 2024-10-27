package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

    private final UserRepo userRepo;

    @Override
    public UserRepo getRepo() {
        return userRepo;
    }

    @Override
    public void updateUserByRole(Long id, String role) {
        log.info("UserDao: updateUserByRole - was called with id: {} and role: {}", id, role);
        getRepo().updateUserByRole(id, role);
    }

}
