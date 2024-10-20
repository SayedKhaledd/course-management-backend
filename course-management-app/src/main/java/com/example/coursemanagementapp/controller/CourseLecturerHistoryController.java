package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseLecturerHistoryDto;
import com.example.coursemanagementapp.service.CourseLecturerHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/course-lecturer-history")
@AllArgsConstructor
public class CourseLecturerHistoryController implements AbstractController<CourseLecturerHistoryService, CourseLecturerHistoryDto> {

    private final CourseLecturerHistoryService courselecturerhistoryService;
    private final ApiResponseBuilder<CourseLecturerHistoryDto> apiResponseBuilder;


    @Override
    public CourseLecturerHistoryService getService() {
        return courselecturerhistoryService;
    }

    @Override
    public ApiResponseBuilder<CourseLecturerHistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


    @GetMapping("/course-lecturer/{courseLecturerId}/field/{fieldName}")
    public ApiResponse<List<CourseLecturerHistoryDto>> findByCourseLecturerIdAndFieldName(@PathVariable Long courseLecturerId, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByCourseLecturerIdAndFieldName(courseLecturerId, fieldName));
    }


}
