package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatusSource {
    PAYMENT_STATUS("PAYMENT_STATUS"),
    REFUND_STATUS("REFUND_STATUS");

    private final String source;

    @JsonValue
    @Override
    public String toString() {
        return source;
    }
}
