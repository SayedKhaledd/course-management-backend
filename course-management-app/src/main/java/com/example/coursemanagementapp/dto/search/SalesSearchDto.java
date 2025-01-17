package com.example.coursemanagementapp.dto.search;

import com.example.coursemanagementapp.enums.PaymentStatusSource;
import com.example.coursemanagementapp.enums.PaymentType;
import lombok.Data;

import java.util.Set;

@Data
public class SalesSearchDto {
    private Long clientId;
    private Set<Long> paymentMethodIds;
    private Set<Long> paymentStatusIds;
    private Set<Long> courseIds;
    private Set<PaymentType> paymentTypes;
    private Set<PaymentStatusSource> paymentStatusSources;
    private Set<String> currencies;
    private String courseCode;
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

    public Set<Long> getCourseIds() {
        if (courseIds == null || courseIds.isEmpty())
            return null;
        return courseIds;
    }

    public Set<String> getCurrencies() {
        if (currencies == null || currencies.isEmpty())
            return null;
        return currencies;
    }

    public Set<PaymentStatusSource> getPaymentStatusSources() {
        if (paymentStatusSources == null || paymentStatusSources.isEmpty())
            return null;
        return paymentStatusSources;
    }
}
