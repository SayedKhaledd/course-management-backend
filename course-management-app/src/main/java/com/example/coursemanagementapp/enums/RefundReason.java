package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefundReason {
    DID_NOT_LIKE_THE_COURSE("DID_NOT_LIKE_THE_COURSE"),
    DID_NOT_ATTEND("DID_NOT_ATTEND"),
    CHANGE_SPECIALITY("Change Specaility"),
    OTHER("Other");
    private final String reason;

    @JsonValue
    @Override
    public String toString() {
        return reason;
    }
}
