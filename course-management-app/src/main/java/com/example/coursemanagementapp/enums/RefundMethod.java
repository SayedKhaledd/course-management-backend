package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RefundMethod {
    CASH("Cash"),
    BANK_DEPOSIT("Bank Deposit"),
    VODAFONE("Vodafone"),
    STRIPE("Stripe"),
    BANK_TRANSFER("Bank transfer");

    private final String method;

    @JsonValue
    @Override
    public String toString() {
        return method;
    }
}