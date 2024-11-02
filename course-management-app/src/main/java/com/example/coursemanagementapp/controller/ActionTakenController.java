package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ActionTakenDto;
import com.example.coursemanagementapp.service.ActionTakenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("/all")
    public ApiResponse<List<ActionTakenDto>> getAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
