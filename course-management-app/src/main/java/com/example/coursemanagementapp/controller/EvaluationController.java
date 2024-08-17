package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.service.EvaluationService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/evaluation")
@AllArgsConstructor
public class EvaluationController implements AbstractController<EvaluationService, EvaluationDto> {

    private final EvaluationService evaluationService;
    private final ApiResponseBuilder<EvaluationDto> apiResponseBuilder;


    @Override
    public EvaluationService getService() {
        return evaluationService;
    }
    
    @Override
    public ApiResponseBuilder<EvaluationDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
