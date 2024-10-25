package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    SUPER_ADMIN("SUPER_ADMIN"),
    ADMIN("ADMIN"),
    ACCOUNTANT("ACCOUNTANT"),
    CUSTOMER_SERVICE("CUSTOMER_SERVICE"),
    SALES("SALES"),
    MARKETING("MARKETING");
    private final String role;

}
