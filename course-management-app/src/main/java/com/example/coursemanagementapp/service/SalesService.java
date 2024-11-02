package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.enums.PaymentType;

import java.util.List;

public interface SalesService {
    List<SalesDto> findAll();

    void updatePaymentType(Long id, PaymentType paymentType, Boolean isReceived);
}
