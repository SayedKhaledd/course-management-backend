package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class UserSearchDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Set<String> roles;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;

    public Set<String> getRoles() {
        if (roles == null || roles.isEmpty())
            return null;
        return roles;
    }
}
