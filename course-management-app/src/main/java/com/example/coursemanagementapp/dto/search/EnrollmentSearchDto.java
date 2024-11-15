package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class EnrollmentSearchDto {
    private Long clientId;
    private Long courseId;
    private Set<String> currencies;
    private Set<Long> paymentStatusIds;
    private Set<Long> paymentMethodIds;
    private Set<Long> referralSourceIds;
    private Set<Long> actionTakenIds;
    private Set<String> ratings;
    private Set<Boolean> payInInstallments;
    private Set<Boolean> insideEgypt;
    private String clientName;
    private String courseName;
    private String description;
    private String review;
    private Double amountPaid;
    private Double remainingAmount;
    private Double totalAmount;
    private Double discount;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;

    public Set<String> getCurrencies() {
        if (currencies == null || currencies.isEmpty())
            return null;
        return currencies;
    }

    public Set<Long> getPaymentStatusIds() {
        if (paymentStatusIds == null || paymentStatusIds.isEmpty())
            return null;
        return paymentStatusIds;
    }

    public Set<Long> getPaymentMethodIds() {
        if (paymentMethodIds == null || paymentMethodIds.isEmpty())
            return null;
        return paymentMethodIds;
    }

    public Set<Long> getReferralSourceIds() {
        if (referralSourceIds == null || referralSourceIds.isEmpty())
            return null;
        return referralSourceIds;
    }

    public Set<Long> getActionTakenIds() {
        if (actionTakenIds == null || actionTakenIds.isEmpty())
            return null;
        return actionTakenIds;
    }

    public Set<String> getRatings() {
        if (ratings == null || ratings.isEmpty())
            return null;
        return ratings;
    }

    public Set<Boolean> getPayInInstallments() {
        if (payInInstallments == null || payInInstallments.isEmpty())
            return null;
        return payInInstallments;
    }

    public Set<Boolean> getInsideEgypt() {
        if (insideEgypt == null || insideEgypt.isEmpty())
            return null;
        return insideEgypt;
    }


}
