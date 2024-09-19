package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import com.example.coursemanagementapp.model.PaymentMethod;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "RefundDtoBuilder")
@Data
public class RefundDto extends AbstractDto {
    private Long id;
    private EnrollmentDto enrollment;
    private Long enrollmentId;
    private PaymentMethod paymentMethod;
    private Long paymentMethodId;
    private PaymentStatusDto paymentStatus;
    private Long paymentStatusId;
    private Double amount;
    private LocalDateTime refundDate;
    private String explanation;
    private RefundReasonDto refundReason;
    private Long refundReasonId;
    private Boolean isConfirmed = false;

}
