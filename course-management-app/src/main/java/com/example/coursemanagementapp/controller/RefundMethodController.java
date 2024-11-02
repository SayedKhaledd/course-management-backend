package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.RefundMethodDto;
import com.example.coursemanagementapp.service.RefundMethodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/refund-method")
@AllArgsConstructor
public class RefundMethodController implements AbstractController<RefundMethodService, RefundMethodDto> {

    private final RefundMethodService refundmethodService;
    private final ApiResponseBuilder<RefundMethodDto> apiResponseBuilder;


    @Override
    public RefundMethodService getService() {
        return refundmethodService;
    }

    @Override
    public ApiResponseBuilder<RefundMethodDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @GetMapping("/all")
    public ApiResponse<List<RefundMethodDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
