package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.service.CourseLecturerService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
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

    //TODO: TEST THIS
    @PostMapping("/create-with-percentage")
    public ApiResponse<CourseLecturerDto> createWithPercentage(@Validated({CourseLecturerDto.CreateWithPercentage.class}) CourseLecturerDto dto) {
        return apiResponseBuilder.buildSuccessResponse(courselecturerService.create(dto));
    }

    //TODO: TEST THIS
    @PostMapping("/create-with-fixed-value")
    public ApiResponse<CourseLecturerDto> createWithFixedValue(@Validated({CourseLecturerDto.CreateWithFixedValue.class}) CourseLecturerDto dto) {
        return apiResponseBuilder.buildSuccessResponse(courselecturerService.create(dto));
    }

}
