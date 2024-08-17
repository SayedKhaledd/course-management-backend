package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.service.ClientStatusService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/client-status")
@AllArgsConstructor
public class ClientStatusController implements AbstractController<ClientStatusService, ClientStatusDto> {

    private final ClientStatusService clientstatusService;
    private final ApiResponseBuilder<ClientStatusDto> apiResponseBuilder;


    @Override
    public ClientStatusService getService() {
        return clientstatusService;
    }
    
    @Override
    public ApiResponseBuilder<ClientStatusDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
