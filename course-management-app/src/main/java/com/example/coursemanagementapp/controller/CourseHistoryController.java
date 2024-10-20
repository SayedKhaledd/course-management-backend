package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseHistoryDto;
import com.example.coursemanagementapp.service.CourseHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/course-history")
@AllArgsConstructor
public class CourseHistoryController implements AbstractController<CourseHistoryService, CourseHistoryDto> {

    private final CourseHistoryService coursehistoryService;
    private final ApiResponseBuilder<CourseHistoryDto> apiResponseBuilder;


    @Override
    public CourseHistoryService getService() {
        return coursehistoryService;
    }

    @Override
    public ApiResponseBuilder<CourseHistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


    @GetMapping("/course/{courseId}/field/{fieldName}")
    public ApiResponse<List<CourseHistoryDto>> findByCourseIdAndFieldName(@PathVariable Long courseId, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByCourseIdAndFieldName(courseId, fieldName));
    }


}
