package com.example.coursemanagementapp.dto.search;

import com.example.coursemanagementapp.enums.PaymentType;
import lombok.Data;

import java.util.Set;

@Data
public class SalesSearchDto {
    private Long clientId;
    private Set<Long> paymentMethodIds;
    private Set<Long> paymentStatusIds;
    private Set<PaymentType> paymentTypes;
    private String courseCode;
    private String currency;
    private Boolean isReceived;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;


    public Set<Long> getPaymentMethodIds() {
        if (paymentMethodIds == null || paymentMethodIds.isEmpty())
            return null;
        return paymentMethodIds;
    }

    public Set<Long> getPaymentStatusIds() {
        if (paymentStatusIds == null || paymentStatusIds.isEmpty())
            return null;
        return paymentStatusIds;
    }

    public Set<PaymentType> getPaymentTypes() {
        if (paymentTypes == null || paymentTypes.isEmpty())
            return null;
        return paymentTypes;
    }
}
