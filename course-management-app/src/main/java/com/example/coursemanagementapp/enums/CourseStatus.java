package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseStatus {
    STARTED("Started"),
    PENDING("Pending");
    private final String status;

    @JsonValue
    @Override
    public String toString() {
        return status;
    }

}
