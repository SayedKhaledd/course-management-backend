package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseDto;
import com.example.coursemanagementapp.dto.search.CourseSearchDto;
import com.example.coursemanagementapp.service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/{id}")
    public ApiResponse<CourseDto> findById(@PathVariable Long id) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findById(id));
    }


    @GetMapping("/all")
    public ApiResponse<List<CourseDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllCoursesNotInitial());
    }
    @GetMapping("/all-initial-courses")
    public ApiResponse<List<CourseDto>> findAllInitialCourses() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllInitialCourses());
    }


    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<CourseDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<CourseSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }


    @PostMapping
    public ApiResponse<CourseDto> create(@RequestBody @Validated(CourseDto.Create.class) CourseDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }


    @PostMapping("/initial")
    public ApiResponse<CourseDto> createInitial(@RequestBody @Validated(CourseDto.CreateInitial.class) CourseDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }

    @PatchMapping("/{id}/name")
    public ApiResponse<?> updateName(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdateName.class) CourseDto dto) {
        getService().updateName(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/code")
    public ApiResponse<?> updateCode(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdateCode.class) CourseDto dto) {
        getService().updateCode(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/part")
    public ApiResponse<?> updatePart(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdatePart.class) CourseDto dto) {
        getService().updatePart(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/price")
    public ApiResponse<?> updatePrice(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdatePrice.class) CourseDto dto) {
        getService().updatePrice(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/description")
    public ApiResponse<?> updateDescription(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdateDescription.class) CourseDto dto) {
        getService().updateDescription(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/start-date")
    public ApiResponse<?> updateStartDate(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdateStartDate.class) CourseDto dto) {
        getService().updateStartDate(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/end-date")
    public ApiResponse<?> updateEndDate(@PathVariable Long id, @RequestBody @Validated(CourseDto.UpdateEndDate.class) CourseDto dto) {
        getService().updateEndDate(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/status/{courseStatusId}")
    public ApiResponse<?> updateCourseStatus(@PathVariable Long id, @PathVariable Long courseStatusId) {
        getService().updateCourseStatus(id, courseStatusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
