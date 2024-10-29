package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefundStatus {
    CONFIRMED("CONFIRMED"),
    NOT_CONFIRMED("NOT_CONFIRMED"),
    CANCELLED("CANCELLED");
    private final String status;
}
