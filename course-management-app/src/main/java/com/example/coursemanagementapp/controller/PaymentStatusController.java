package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.PaymentStatusDto;
import com.example.coursemanagementapp.service.PaymentStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/payment-status")
@AllArgsConstructor
public class PaymentStatusController implements AbstractController<PaymentStatusService, PaymentStatusDto> {

    private final PaymentStatusService paymentstatusService;
    private final ApiResponseBuilder<PaymentStatusDto> apiResponseBuilder;


    @Override
    public PaymentStatusService getService() {
        return paymentstatusService;
    }

    @Override
    public ApiResponseBuilder<PaymentStatusDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


    @GetMapping("/all")
    public ApiResponse<List<PaymentStatusDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
