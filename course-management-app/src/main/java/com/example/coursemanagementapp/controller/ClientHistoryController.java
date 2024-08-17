package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.service.ClientHistoryService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/client-history")
@AllArgsConstructor
public class ClientHistoryController implements AbstractController<ClientHistoryService, ClientHistoryDto> {

    private final ClientHistoryService clienthistoryService;
    private final ApiResponseBuilder<ClientHistoryDto> apiResponseBuilder;


    @Override
    public ClientHistoryService getService() {
        return clienthistoryService;
    }
    
    @Override
    public ApiResponseBuilder<ClientHistoryDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
