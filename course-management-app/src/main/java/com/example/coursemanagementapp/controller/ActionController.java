package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ActionDto;
import com.example.coursemanagementapp.service.ActionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/action")
@AllArgsConstructor
public class ActionController implements AbstractController<ActionService, ActionDto> {

    private final ActionService actionService;
    private final ApiResponseBuilder<ActionDto> apiResponseBuilder;


    @Override
    public ActionService getService() {
        return actionService;
    }

    @Override
    public ApiResponseBuilder<ActionDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
