package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.service.EvaluationService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
