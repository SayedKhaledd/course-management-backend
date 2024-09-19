package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "InstallmentDtoBuilder")
@Data
public class InstallmentDto extends AbstractDto {
    private Long id;
    private EnrollmentDto enrollment;
    private Long enrollmentId;
    private Double amount;
    private LocalDateTime dueDate;
    private LocalDateTime paymentDate;
    private PaymentStatusDto paymentStatus;
    private Long paymentStatusId;
    private PaymentMethodDto paymentMethod;
    private Long paymentMethodId;
}
