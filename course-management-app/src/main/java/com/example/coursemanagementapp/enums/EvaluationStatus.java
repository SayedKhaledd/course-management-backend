package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EvaluationStatus {
    PASSED("PASSED"),
    FAILED("FAILED"),
    NOT_AVAILABLE("NOT_AVAILABLE");
    private final String status;

    @JsonValue
    @Override
    public String toString() {
        return status;
    }
}
