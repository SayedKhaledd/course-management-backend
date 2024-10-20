package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.coursemanagementapp.dto.InstallmentHistoryDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.EvaluationHistoryDto;
import com.example.coursemanagementapp.service.EvaluationHistoryService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;

import java.util.List;


@RestController
@RequestMapping("/api/evaluation-history")
@AllArgsConstructor
public class EvaluationHistoryController implements AbstractController<EvaluationHistoryService, EvaluationHistoryDto> {

    private final EvaluationHistoryService evaluationhistoryService;
    private final ApiResponseBuilder<EvaluationHistoryDto> apiResponseBuilder;


    @Override
    public EvaluationHistoryService getService() {
        return evaluationhistoryService;
    }
    
    @Override
    public ApiResponseBuilder<EvaluationHistoryDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }

    @GetMapping("/evaluation/{evaluationId}/field/{fieldName}")
    public ApiResponse<List<EvaluationHistoryDto>> findByEvaluationIdAndFieldName(@PathVariable Long evaluationId, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByEvaluationIdAndFieldName(evaluationId, fieldName));
    }



}
