package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.enums.PaymentType;
import com.example.coursemanagementapp.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/sales")
@AllArgsConstructor
public class SalesController {
    private final SalesService salesService;
    private final ApiResponseBuilder apiResponseBuilder;

    public SalesService getService() {
        return salesService;
    }

    public ApiResponseBuilder getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')  OR hasAuthority( 'CUSTOMER_SERVICE')")
    @GetMapping("/all")
    public ApiResponse<List<SalesDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')  OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/payment-type/{paymentType}/is-received/{isReceived}")
    public ApiResponse<?> updatePaymentType(@PathVariable Long id, @PathVariable PaymentType paymentType, @PathVariable Boolean isReceived) {
        getService().updatePaymentType(id, paymentType, isReceived);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
