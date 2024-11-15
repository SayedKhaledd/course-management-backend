package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class RefundSearchDto {
    private Long enrollmentId;
    private Set<Long> paymentMethodIds;
    private Set<Long> refundMethodIds;
    private Set<Long> refundStatusIds;
    private Set<Long> refundReasonIds;
    private String clientName;
    private String courseName;
    private String firstExplanation;
    private String secondExplanation;
    private String refundDate;
    private Double refundedAmount;
    private Double enrollmentAmount;
    private String createdBy;
    private String modifiedBy;
    private String createdDate;
    private String modifiedDate;

    public Set<Long> getPaymentMethodIds() {
        if (paymentMethodIds == null || paymentMethodIds.isEmpty())
            return null;
        return paymentMethodIds;
    }

    public Set<Long> getRefundMethodIds() {
        if (refundMethodIds == null || refundMethodIds.isEmpty())
            return null;
        return refundMethodIds;
    }

    public Set<Long> getRefundStatusIds() {
        if (refundStatusIds == null || refundStatusIds.isEmpty())
            return null;
        return refundStatusIds;
    }

    public Set<Long> getRefundReasonIds() {
        if (refundReasonIds == null || refundReasonIds.isEmpty())
            return null;
        return refundReasonIds;
    }


}
