package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.service.EnrollmentHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/enrollment-history")
@AllArgsConstructor
public class EnrollmentHistoryController implements AbstractController<EnrollmentHistoryService, EnrollmentHistoryDto> {

    private final EnrollmentHistoryService enrollmenthistoryService;
    private final ApiResponseBuilder<EnrollmentHistoryDto> apiResponseBuilder;


    @Override
    public EnrollmentHistoryService getService() {
        return enrollmenthistoryService;
    }

    @Override
    public ApiResponseBuilder<EnrollmentHistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


    @GetMapping("/enrollment/{enrollmentId}/field/{fieldName}")
    public ApiResponse<List<EnrollmentHistoryDto>> findByEnrollmentIdAndFieldName(@PathVariable Long enrollmentId, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByEnrollmentIdAndFieldName(enrollmentId,fieldName));
    }
}
