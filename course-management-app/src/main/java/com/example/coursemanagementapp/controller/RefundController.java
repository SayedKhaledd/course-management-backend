package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.service.RefundService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/refund")
@AllArgsConstructor
public class RefundController implements AbstractController<RefundService, RefundDto> {

    private final RefundService refundService;
    private final ApiResponseBuilder<RefundDto> apiResponseBuilder;


    @Override
    public RefundService getService() {
        return refundService;
    }

    @Override
    public ApiResponseBuilder<RefundDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
