package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CASH("CASH"),
    CARD("CARD"),
    THIRD_PARTY("THIRD_PARTY");
    private final String method;
}
