package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.service.ActionTakenService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/action-taken")
@AllArgsConstructor
public class ActionTakenController implements AbstractController<ActionTakenService, ActionTakenDto> {

    private final ActionTakenService actiontakenService;
    private final ApiResponseBuilder<ActionTakenDto> apiResponseBuilder;


    @Override
    public ActionTakenService getService() {
        return actiontakenService;
    }
    
    @Override
    public ApiResponseBuilder<ActionTakenDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
