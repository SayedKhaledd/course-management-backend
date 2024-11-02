package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    DONE("Done"),
    WAITING("waiting"),
    CANCELED("Canceled");
    private final String status;

    @JsonValue
    @Override
    public String toString() {
        return status;
    }
}
