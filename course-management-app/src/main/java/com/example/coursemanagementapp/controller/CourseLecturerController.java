package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.service.CourseLecturerService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/course/{courseId}")
    public ApiResponse<List<CourseLecturerDto>> findAllByCourseId(@PathVariable Long courseId) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByCourseId(courseId));
    }

    @PostMapping()
    public ApiResponse<CourseLecturerDto> create(@Validated({CourseLecturerDto.Create.class}) @RequestBody CourseLecturerDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }

    @PatchMapping("/{id}/paid-in-percentage/{paidInPercentage}")
    public ApiResponse<?> updatePaidInPercentage(@PathVariable Long id, @PathVariable Boolean paidInPercentage) {
        getService().updatePaidInPercentage(id, paidInPercentage);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/percentage")
    public ApiResponse<?> updatePercentage(@PathVariable Long id, @RequestBody @Validated(CourseLecturerDto.UpdatePercentage.class) CourseLecturerDto dto) {
        getService().updatePercentage(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/fixed-value")
    public ApiResponse<?> updateFixedValue(@PathVariable Long id, @RequestBody @Validated(CourseLecturerDto.UpdateFixedValue.class) CourseLecturerDto dto) {
        getService().updateFixedValue(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
