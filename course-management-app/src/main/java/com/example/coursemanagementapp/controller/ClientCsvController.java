package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.coursemanagementapp.dto.ParsedClient;
import com.example.coursemanagementapp.service.ClientCsvService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/api/client-csv")
@AllArgsConstructor
public class ClientCsvController {
    private final ClientCsvService clientCsvService;

    private final ApiResponseBuilder<ParsedClient> apiResponseBuilder;

    @PostMapping(value = "/parse", consumes = "multipart/form-data")
    public ApiResponse<?> parseClients(@RequestBody MultipartFile file) {
        return apiResponseBuilder.buildSuccessResponse(clientCsvService.parseClients(file));
    }

    @PostMapping(value = "/save", consumes = "application/json")
    public ApiResponse<?> saveParsedClients(@RequestBody @Valid List<ParsedClient> parsedClients) {
        clientCsvService.saveParsedClients(parsedClients);
        return apiResponseBuilder.buildSuccessResponse();
    }

}
