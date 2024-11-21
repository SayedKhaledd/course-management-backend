package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import com.example.coursemanagementapp.enums.PaymentType;
import com.example.coursemanagementapp.model.Client;
import com.example.coursemanagementapp.model.Course;
import com.example.coursemanagementapp.model.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "SalesDtoBuilder")
@Data
public class SalesDto extends AbstractDto {
    private Long entityId;
    private PaymentType type;
    private Client client;
    private Long clientId;
    private Course course;
    private Long courseId;
    private Double amount;
    private PaymentMethod paymentMethod;
    private Long paymentMethodId;
    private Long paymentStatusId;
    private Object paymentStatus;
    private String currency;
    private Boolean isReceived;
}
