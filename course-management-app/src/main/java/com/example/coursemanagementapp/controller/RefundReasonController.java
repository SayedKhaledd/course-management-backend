package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.RefundReasonDto;
import com.example.coursemanagementapp.service.RefundReasonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/refund-reason")
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

    @GetMapping("/all")
    public ApiResponse<List<RefundReasonDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
