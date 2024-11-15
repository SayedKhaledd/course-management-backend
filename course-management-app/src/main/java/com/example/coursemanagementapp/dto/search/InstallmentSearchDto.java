package com.example.coursemanagementapp.dto.search;

import lombok.Data;

import java.util.Set;

@Data
public class InstallmentSearchDto {
    private Long enrollmentId;
    private Set<Long> paymentMethodIds;
    private Set<Long> paymentStatusIds;
    private String clientName;
    private String courseName;
    private Double amount;
    private String dueDate;
    private String paymentDate;
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

}
