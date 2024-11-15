package com.example.coursemanagementapp.validator;

import com.example.coursemanagementapp.enums.Role;

public interface UserValidator {
    Boolean shouldUpdateRole( Role userRoleToUpdate);
}
