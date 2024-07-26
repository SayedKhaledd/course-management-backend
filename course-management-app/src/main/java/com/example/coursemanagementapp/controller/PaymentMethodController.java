package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.PaymentMethodDto;
import com.example.coursemanagementapp.service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/paymentmethod")
@AllArgsConstructor
public class PaymentMethodController implements AbstractController<PaymentMethodService, PaymentMethodDto> {

    private final PaymentMethodService paymentmethodService;
    private final ApiResponseBuilder<PaymentMethodDto> apiResponseBuilder;


    @Override
    public PaymentMethodService getService() {
        return paymentmethodService;
    }

    @Override
    public ApiResponseBuilder<PaymentMethodDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
