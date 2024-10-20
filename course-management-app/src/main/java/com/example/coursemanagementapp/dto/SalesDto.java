package com.example.coursemanagementapp.dto;

import com.example.coursemanagementapp.enums.PaymentMethod;
import com.example.coursemanagementapp.enums.PaymentType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SalesDto {
    private String clientName;
    private String courseCode;
    private String courseName;
    private BigDecimal amount;
    private LocalDateTime date;
    private PaymentType paymentType;
    private PaymentMethod paymentMethod;
    private String currency;

}
