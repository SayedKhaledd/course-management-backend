package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.service.EvaluationStatusService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/evaluation-status")
@AllArgsConstructor
public class EvaluationStatusController implements AbstractController<EvaluationStatusService, EvaluationStatusDto> {

    private final EvaluationStatusService evaluationstatusService;
    private final ApiResponseBuilder<EvaluationStatusDto> apiResponseBuilder;


    @Override
    public EvaluationStatusService getService() {
        return evaluationstatusService;
    }
    
    @Override
    public ApiResponseBuilder<EvaluationStatusDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
