package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.service.ClientHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("/client/{clientId}")
    public ApiResponse<List<ClientHistoryDto>> findByClientId(@PathVariable Long clientId) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByClientId(clientId));
    }

    @GetMapping("/field/{fieldName}")
    public ApiResponse<List<ClientHistoryDto>> findByFieldName(@PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByFieldName(fieldName));
    }

}
