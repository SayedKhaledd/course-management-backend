package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.RefundStatusDto;
import com.example.coursemanagementapp.service.RefundStatusService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;

import java.util.List;


@RestController
@RequestMapping("/api/refund-status")
@AllArgsConstructor
public class RefundStatusController implements AbstractController<RefundStatusService, RefundStatusDto> {

    private final RefundStatusService refundstatusService;
    private final ApiResponseBuilder<RefundStatusDto> apiResponseBuilder;


    @Override
    public RefundStatusService getService() {
        return refundstatusService;
    }
    
    @Override
    public ApiResponseBuilder<RefundStatusDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }


    @GetMapping("/all")
    public ApiResponse<List<RefundStatusDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }



}
