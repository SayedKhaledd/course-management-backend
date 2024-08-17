package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.CourseStatusDto;
import com.example.coursemanagementapp.service.CourseStatusService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/course-status")
@AllArgsConstructor
public class CourseStatusController implements AbstractController<CourseStatusService, CourseStatusDto> {

    private final CourseStatusService coursestatusService;
    private final ApiResponseBuilder<CourseStatusDto> apiResponseBuilder;


    @Override
    public CourseStatusService getService() {
        return coursestatusService;
    }
    
    @Override
    public ApiResponseBuilder<CourseStatusDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}
