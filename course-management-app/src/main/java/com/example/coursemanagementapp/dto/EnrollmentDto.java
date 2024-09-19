package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "EnrollmentDtoBuilder")
@Data
public class EnrollmentDto extends AbstractDto {
    private Long id;
    private CourseDto course;
    private Long courseId;
    private ClientDto client;
    private Long clientId;
    private Double amountPaid;
    private Double remainingAmount;
    private String currency;
    private Double discount;
    private PaymentStatusDto paymentStatus;
    private Long paymentStatusId;
    private PaymentMethodDto paymentMethod;
    private Long paymentMethodId;
    private Boolean payInInstallments = false;
    private String review;
    private Integer rating;
    private String description;
    private ActionTakenDto actionTaken;
    private Long actionTakenId;
    private ReferralSourceDto referralSource;
    private Long referralSourceId;
}
