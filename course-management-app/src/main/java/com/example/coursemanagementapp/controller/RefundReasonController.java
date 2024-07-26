package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.RefundReasonDto;
import com.example.coursemanagementapp.service.RefundReasonService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/refundreason")
@AllArgsConstructor
public class RefundReasonController implements AbstractController<RefundReasonService, RefundReasonDto> {

    private final RefundReasonService refundreasonService;
    private final ApiResponseBuilder<RefundReasonDto> apiResponseBuilder;


    @Override
    public RefundReasonService getService() {
        return refundreasonService;
    }

    @Override
    public ApiResponseBuilder<RefundReasonDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
