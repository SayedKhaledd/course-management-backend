package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.InstallmentHistoryDto;
import com.example.coursemanagementapp.service.InstallmentHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/installment-history")
@AllArgsConstructor
public class InstallmentHistoryController implements AbstractController<InstallmentHistoryService, InstallmentHistoryDto> {

    private final InstallmentHistoryService installmenthistoryService;
    private final ApiResponseBuilder<InstallmentHistoryDto> apiResponseBuilder;


    @Override
    public InstallmentHistoryService getService() {
        return installmenthistoryService;
    }

    @Override
    public ApiResponseBuilder<InstallmentHistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


    @GetMapping("/installment/{installmentId}/field/{fieldName}")
    public ApiResponse<List<InstallmentHistoryDto>> findByInstallmentIdAndFieldName(@PathVariable Long installmentId, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByInstallmentIdAndFieldName(installmentId, fieldName));
    }


}
