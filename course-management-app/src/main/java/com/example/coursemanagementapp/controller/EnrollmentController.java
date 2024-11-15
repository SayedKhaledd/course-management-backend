package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/enrollment")
@AllArgsConstructor
public class EnrollmentController implements AbstractController<EnrollmentService, EnrollmentDto> {

    private final EnrollmentService enrollmentService;
    private final ApiResponseBuilder<EnrollmentDto> apiResponseBuilder;


    @Override
    public EnrollmentService getService() {
        return enrollmentService;
    }

    @Override
    public ApiResponseBuilder<EnrollmentDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @GetMapping("/all")
    public ApiResponse<List<EnrollmentDto>> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @GetMapping("/client/{id}")
    public ApiResponse<List<EnrollmentDto>> findAllByClientId(@PathVariable Long id) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByClientId(id));
    }

    @GetMapping("/client/{clientId}/course/{courseId}")
    public ApiResponse<EnrollmentDto> findByClientIdAndCourseId(@PathVariable Long clientId, @PathVariable Long courseId) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findByClientIdAndCourseId(clientId, courseId));
    }

    @GetMapping("/course/{id}")
    public ApiResponse<List<EnrollmentDto>> findAllByCourseId(@PathVariable Long id) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByCourseId(id));
    }

    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<EnrollmentDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<EnrollmentSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }


    @PostMapping
    public ApiResponse<EnrollmentDto> create(@Validated(EnrollmentDto.Create.class) @RequestBody EnrollmentDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }

    @PatchMapping("/{id}/amount-paid")
    public ApiResponse<?> updateAmountPaid(@PathVariable Long id, @RequestBody @Validated(EnrollmentDto.UpdateAmountPaid.class) EnrollmentDto dto) {
        getService().updateAmountPaid(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PatchMapping("/{id}/discount")
    public ApiResponse<?> updateDiscount(@PathVariable Long id, @RequestBody @Validated(EnrollmentDto.UpdateDiscount.class) EnrollmentDto dto) {
        getService().updateDiscount(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PatchMapping("/{id}/currency")
    public ApiResponse<?> updateCurrency(@PathVariable Long id, @RequestBody @Validated(EnrollmentDto.UpdateCurrency.class) EnrollmentDto dto) {
        getService().updateCurrency(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/pay-in-installments/{payInInstallments}")
    public ApiResponse<?> updatePayInInstallments(@PathVariable Long id, @PathVariable Boolean payInInstallments) {
        getService().updatePayInInstallments(id, payInInstallments);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/inside-egypt/{insideEgypt}")
    public ApiResponse<?> updateInsideEgypt(@PathVariable Long id, @PathVariable Boolean insideEgypt) {
        getService().updateInsideEgypt(id, insideEgypt);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/review")
    public ApiResponse<?> updateReview(@PathVariable Long id, @RequestBody @Validated(EnrollmentDto.UpdateReview.class) EnrollmentDto dto) {
        getService().updateReview(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/rating")
    public ApiResponse<?> updateRating(@PathVariable Long id, @RequestBody @Validated(EnrollmentDto.UpdateRating.class) EnrollmentDto dto) {
        getService().updateRating(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/description")
    public ApiResponse<?> updateDescription(@PathVariable Long id, @RequestBody @Validated(EnrollmentDto.UpdateDescription.class) EnrollmentDto dto) {
        getService().updateDescription(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/payment-status/{paymentStatusId}")
    public ApiResponse<?> updatePaymentStatus(@PathVariable Long id, @PathVariable Long paymentStatusId) {
        getService().updatePaymentStatus(id, paymentStatusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/payment-method/{paymentMethodId}")
    public ApiResponse<?> updatePaymentMethod(@PathVariable Long id, @PathVariable Long paymentMethodId) {
        getService().updatePaymentMethod(id, paymentMethodId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/action-taken/{actionTakenId}")
    public ApiResponse<?> updateActionTaken(@PathVariable Long id, @PathVariable Long actionTakenId) {
        getService().updateActionTaken(id, actionTakenId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/referral-source/{referralSourceId}")
    public ApiResponse<?> updateReferralSource(@PathVariable Long id, @PathVariable Long referralSourceId) {
        getService().updateReferralSource(id, referralSourceId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/client/{clientId}")
    public ApiResponse<?> updateClient(@PathVariable Long id, @PathVariable Long clientId) {
        getService().updateClient(id, clientId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/course/{courseId}")
    public ApiResponse<?> updateCourse(@PathVariable Long id, @PathVariable Long courseId) {
        getService().updateCourse(id, courseId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
