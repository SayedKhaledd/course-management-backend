package com.example.coursemanagementapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.service.CourseLecturerService;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.backendcoreservice.api.ApiResponseBuilder;


@RestController
@RequestMapping("/api/course-lecturer")
@AllArgsConstructor
public class CourseLecturerController implements AbstractController<CourseLecturerService, CourseLecturerDto> {

    private final CourseLecturerService courselecturerService;
    private final ApiResponseBuilder<CourseLecturerDto> apiResponseBuilder;


    @Override
    public CourseLecturerService getService() {
        return courselecturerService;
    }
    
    @Override
    public ApiResponseBuilder<CourseLecturerDto> getApiResponseBuilder() {
    return apiResponseBuilder;
    }





}