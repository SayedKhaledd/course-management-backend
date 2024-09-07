package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
public class CourseController implements AbstractController<CourseService, CourseDto> {

    private final CourseService courseService;
    private final ApiResponseBuilder<CourseDto> apiResponseBuilder;


    @Override
    public CourseService getService() {
        return courseService;
    }

    @Override
    public ApiResponseBuilder<CourseDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


}
