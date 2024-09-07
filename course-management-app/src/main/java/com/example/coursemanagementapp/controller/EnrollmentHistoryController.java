package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.service.EnrollmentHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


}
