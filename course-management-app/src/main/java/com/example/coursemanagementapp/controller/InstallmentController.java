package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.service.InstallmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/installment")
@AllArgsConstructor
public class InstallmentController implements AbstractController<InstallmentService, InstallmentDto> {

    private final InstallmentService installmentService;
    private final ApiResponseBuilder<InstallmentDto> apiResponseBuilder;


    @Override
    public InstallmentService getService() {
        return installmentService;
    }

    @Override
    public ApiResponseBuilder<InstallmentDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
