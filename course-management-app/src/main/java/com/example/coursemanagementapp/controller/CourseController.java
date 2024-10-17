package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.service.CourseService;
import jakarta.validation.Valid;
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

    @GetMapping("/all")
    public ApiResponse<?> findAll() {
        return apiResponseBuilder.buildSuccessResponse(getService().findAll());
    }

    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<CourseDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<CourseSearchDto> paginationRequest) {
        return apiResponseBuilder.buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }


    //TODO: TEST THIS
    @PostMapping
    public ApiResponse<CourseDto> create(@RequestBody @Validated CourseDto dto) {
        return apiResponseBuilder.buildSuccessResponse(getService().create(dto));
    }

    //TODO: TEST THIS
    @PatchMapping("/{id}/update/status/{statusId}")
    public ApiResponse<?> updateStatus(@PathVariable Long id, @PathVariable Long statusId) {
        getService().updateStatus(id, statusId);
        return apiResponseBuilder.buildSuccessResponse();
    }

    //TODO: TEST THIS
    @PutMapping("/{id}")
    public ApiResponse<CourseDto> update(@PathVariable Long id, @RequestBody @Validated CourseDto dto) {
        return apiResponseBuilder.buildSuccessResponse(getService().update(dto, id));
    }

}
