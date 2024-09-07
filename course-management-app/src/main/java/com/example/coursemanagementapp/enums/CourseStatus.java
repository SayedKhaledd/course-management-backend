package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CourseStatus {
    STARTED("STARTED"),
    NOT_STARTED("NOT_STARTED");
    private final String status;


}
