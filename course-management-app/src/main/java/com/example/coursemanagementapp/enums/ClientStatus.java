package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ClientStatus {
    INTERESTED("INTERESTED"),
    NOT_INTERESTED("NOT_INTERESTED"),
    NEEDS_MORE_INFO("NEEDS_MORE_INFO");
    private final String status;
}
