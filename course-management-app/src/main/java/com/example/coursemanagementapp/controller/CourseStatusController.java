package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseStatusDto;
import com.example.coursemanagementapp.service.CourseStatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

    @GetMapping("/all")
    public ApiResponse<List<CourseStatusDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


}
