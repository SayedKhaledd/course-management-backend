package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentType {
    INSTALLMENT("INSTALLMENT"),
    COURSE_PURCHASE("COURSE_PURCHASE"),
    REFUND("REFUND");

    private final String type;

    @JsonValue
    @Override
    public String toString() {
        return type;
    }
}

