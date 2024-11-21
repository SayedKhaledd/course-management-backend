package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.dto.search.EvaluationSearchDto;
import com.example.coursemanagementapp.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/evaluation")
@AllArgsConstructor
public class EvaluationController implements AbstractController<EvaluationService, EvaluationDto> {

    private final EvaluationService evaluationService;
    private final ApiResponseBuilder<EvaluationDto> apiResponseBuilder;


    @Override
    public EvaluationService getService() {
        return evaluationService;
    }

    @Override
    public ApiResponseBuilder<EvaluationDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<EvaluationDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<EvaluationSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }

    @PostMapping
    public ApiResponse<EvaluationDto> create(@RequestBody @Validated({EnrollmentDto.Create.class, EvaluationDto.Create.class}) EvaluationDto evaluationDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(evaluationDto));
    }

    @PutMapping("/{id}/exam-name")
    public ApiResponse<?> updateExamName(@RequestBody @Validated({EvaluationDto.UpdateExamName.class}) EvaluationDto evaluationDto, @PathVariable Long id) {
        getService().updateExamName(evaluationDto, id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PutMapping("/{id}/evaluation-status/{evaluationStatusId}")
    public ApiResponse<?> updateEvaluationStatus(@PathVariable Long id, @PathVariable Long evaluationStatusId) {
        getService().updateEvaluationStatus(id, evaluationStatusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }

}
