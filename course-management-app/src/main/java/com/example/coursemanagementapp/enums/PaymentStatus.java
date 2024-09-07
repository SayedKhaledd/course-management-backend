package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PAID("PAID"),
    NOT_PAID("NOT_PAID"),
    PENDING("PENDING");
    private final String status;

}
