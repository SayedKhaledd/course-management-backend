package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/enrollment")
@AllArgsConstructor
public class EnrollmentController implements AbstractController<EnrollmentService, EnrollmentDto> {

    private final EnrollmentService enrollmentService;
    private final ApiResponseBuilder<EnrollmentDto> apiResponseBuilder;


    @Override
    public EnrollmentService getService() {
        return enrollmentService;
    }

    @Override
    public ApiResponseBuilder<EnrollmentDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
