package com.example.coursemanagementapp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum PaymentStatus {
    PAID("PAID"),
    UNPAID("UNPAID"),
    ;
    @Setter
    @Getter
    private String status;

}
