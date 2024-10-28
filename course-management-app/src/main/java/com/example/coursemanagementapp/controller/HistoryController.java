package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/history")
@AllArgsConstructor
public class HistoryController implements AbstractController<HistoryService, HistoryDto> {

    private final HistoryService historyService;
    private final ApiResponseBuilder<HistoryDto> apiResponseBuilder;


    @Override
    public HistoryService getService() {
        return historyService;
    }

    @Override
    public ApiResponseBuilder<HistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @GetMapping("/entity/{entityId}/entity-type/{entityType}/field-name/{fieldName}")
    public ApiResponse<List<HistoryDto>> findAllByEntityIdAndEntityTypeAndFieldName(@PathVariable Long entityId, @PathVariable String entityType, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByEntityIdAndEntityTypeAndFieldName(entityId, entityType, fieldName));
    }

}
