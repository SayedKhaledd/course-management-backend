package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionTaken {
    ENROLLED("ENROLLED"),
    DID_NOT_ENROLL("DID_NOT_ENROLL"),
    CANCELLED("CANCELLED");
    private final String action;

}
