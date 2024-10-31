package com.example.coursemanagementapp.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentMethod {
    CASH_EGP("Cash EGP"),
    CASH_USD("Cash USD $"),
    QNB("QNB"),
    PAYSKY("Paysky"),
    PAYSKY_UAE("Paysky UAE"),
    FAISL_USD("Faisl USD"),
    FAISL_EGP("Faisl EGP"),
    WIO_BANK("WIO Bank"),
    STRIPE("STRIPE"),
    VODAFONE("Vodafone"),
    WESTRAN_UNION("Westran Union"),
    ADIB("ADIB"),
    GHAIT_FAISAL("Ghait Faisal");

    private final String method;

    @JsonValue
    @Override
    public String toString() {
        return method;
    }
}
