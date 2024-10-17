package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.service.SalesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/all")
    public ApiResponse<List<SalesDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

}
