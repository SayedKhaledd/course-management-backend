package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.service.ClientService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController implements AbstractController<ClientService, ClientDto> {

    private final ClientService clientService;
    private final ApiResponseBuilder<ClientDto> apiResponseBuilder;


    @Override
    public ClientService getService() {
        return clientService;
    }
    
    @Override
    public ApiResponseBuilder<ClientDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
