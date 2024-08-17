package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ClientStatusDto;
import com.example.coursemanagementapp.service.ClientStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("/all")
    public ApiResponse<List<ClientStatusDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
