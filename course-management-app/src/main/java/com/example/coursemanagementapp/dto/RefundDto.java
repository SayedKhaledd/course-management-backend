package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import com.example.coursemanagementapp.model.PaymentMethod;
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
    private Long enrollmentId;
    private PaymentMethod paymentMethod;
    private Long paymentMethodId;
    @NotNull(message = "Amount is mandatory", groups = {Create.class, UpdateAmount.class})
    private Double amount;
    @NotNull(message = "Refund date is mandatory", groups = {UpdateRefundDate.class})
    private LocalDateTime refundDate;
    @NotNull(message = "Explanation is mandatory", groups = {UpdateExplanation.class})
    private String explanation;
    private RefundReasonDto refundReason;
    private Long refundReasonId;
    private Boolean isConfirmed = false;

    public interface Create {

    }

    public interface UpdateAmount {

    }

    public interface UpdateRefundDate {

    }

    public interface UpdateExplanation {

    }


}
