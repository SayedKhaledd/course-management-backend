package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/course")
@AllArgsConstructor
@Validated
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

    //TODO: TEST THIS
    @PostMapping
    public ApiResponse<CourseDto> create(@Validated CourseDto dto) {
        return apiResponseBuilder.buildSuccessResponse(courseService.create(dto));
    }
    //TODO: TEST THIS
    @PatchMapping("/{id}/update/status/{statusId}")
    public ApiResponse<?> updateStatus(@PathVariable Long id, @PathVariable Long statusId) {
        courseService.updateStatus(id, statusId);
        return apiResponseBuilder.buildSuccessResponse();
    }
    //TODO: TEST THIS
    @PutMapping("/{id}")
    public ApiResponse<CourseDto> update(@PathVariable Long id, @Validated CourseDto dto) {
        return apiResponseBuilder.buildSuccessResponse(courseService.update(dto, id));
    }

}
