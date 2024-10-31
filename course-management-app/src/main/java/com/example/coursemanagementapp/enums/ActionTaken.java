package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionTaken {
    ENROLLED("ENROLLED"),
    REFUND("Refund"),
    STOPPED("Stopped");
    private final String action;

    @JsonValue
    @Override
    public String toString() {
        return action;
    }
}
