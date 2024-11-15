package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.CourseLecturerDto;
import com.example.coursemanagementapp.dto.search.CourseLecturerSearchDto;
import com.example.coursemanagementapp.service.CourseLecturerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<CourseLecturerDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<CourseLecturerSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
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
        getService().updatePercentageAndTotalPercentageCost(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PatchMapping("/{id}/no-of-lectures")
    public ApiResponse<?> updateNoOfLectures(@PathVariable Long id, @RequestBody @Validated(CourseLecturerDto.UpdateNoOfLectures.class) CourseLecturerDto dto) {
        getService().updateNoOfLectures(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/lecture-cost")
    public ApiResponse<?> updateLectureCost(@PathVariable Long id, @RequestBody @Validated(CourseLecturerDto.UpdateLectureCost.class) CourseLecturerDto dto) {
        getService().updateLectureCost(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
