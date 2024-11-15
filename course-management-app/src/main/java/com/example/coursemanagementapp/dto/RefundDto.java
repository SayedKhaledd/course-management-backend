package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import com.example.coursemanagementapp.model.PaymentMethod;
import com.example.coursemanagementapp.model.RefundStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "RefundDtoBuilder")
@Data
public class RefundDto extends AbstractDto {
    private Long id;
    private EnrollmentDto enrollment;
    @NotNull(message = "enrollmentId is mandatory", groups = {Create.class})
    private Long enrollmentId;
    private PaymentMethod paymentMethod;
    private Long paymentMethodId;

    @NotNull(message = "RefundedAmount is mandatory", groups = {Create.class, UpdateRefundedAmount.class})
    private Double refundedAmount;
    private Double enrollmentAmount;

    @NotNull(message = "Refund date is mandatory", groups = {UpdateRefundDate.class})
    private LocalDateTime refundDate;

    @NotNull(message = "First Explanation is mandatory", groups = {UpdateFirstExplanation.class})
    private String firstExplanation;

    @NotNull(message = "Second Explanation is mandatory", groups = {UpdateSecondExplanation.class})
    private String secondExplanation;

    private RefundReasonDto refundReason;
    private Long refundReasonId;
    private RefundStatus refundStatus;

    private RefundMethodDto refundMethod;
    private Long refundMethodId;

    private Long refundStatusId;
    private Boolean isReceived = false;


    public interface Create {

    }

    public interface UpdateRefundedAmount {

    }

    public interface UpdateRefundDate {

    }

    public interface UpdateFirstExplanation {

    }

    public interface UpdateSecondExplanation {

    }


}
