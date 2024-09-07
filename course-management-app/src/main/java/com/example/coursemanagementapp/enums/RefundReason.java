package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefundReason {
    DID_NOT_LIKE_THE_COURSE("DID_NOT_LIKE_THE_COURSE"),
    DID_NOT_ATTEND_THE_COURSE("DID_NOT_ATTEND_THE_COURSE"),
    OTHER("OTHER");
    private final String reason;
}
