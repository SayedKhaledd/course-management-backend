package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.service.EvaluationStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("/all")
    public ApiResponse<List<EvaluationStatusDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
