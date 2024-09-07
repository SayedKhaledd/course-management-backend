package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EvaluationStatus {
    PASSED("PASSED"),
    FAILED("FAILED"),
    NOT_AVAILABLE("NOT_AVAILABLE");
    private final String status;
}
