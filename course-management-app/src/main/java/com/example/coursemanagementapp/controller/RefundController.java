package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.dto.search.RefundSearchDto;
import com.example.coursemanagementapp.service.RefundService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/refund")
@AllArgsConstructor
public class RefundController implements AbstractController<RefundService, RefundDto> {

    private final RefundService refundService;
    private final ApiResponseBuilder<RefundDto> apiResponseBuilder;


    @Override
    public RefundService getService() {
        return refundService;
    }

    @Override
    public ApiResponseBuilder<RefundDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @GetMapping("/all")
    public ApiResponse<?> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<RefundDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<RefundSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PostMapping
    public ApiResponse<RefundDto> create(@Validated({RefundDto.Create.class}) @RequestBody RefundDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/refunded-amount")
    public ApiResponse<?> updateRefundedAmount(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateRefundedAmount.class) RefundDto dto) {
        getService().updateRefundedAmount(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/refund-date")
    public ApiResponse<?> updateRefundDate(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateRefundDate.class) RefundDto dto) {
        getService().updateRefundDate(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/first-explanation")
    public ApiResponse<?> updateFirstExplanation(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateFirstExplanation.class) RefundDto dto) {
        getService().updateFirstExplanation(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/second-explanation")
    public ApiResponse<?> updateSecondExplanation(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateSecondExplanation.class) RefundDto dto) {
        getService().updateSecondExplanation(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/refund-method/{refundMethodId}")
    public ApiResponse<?> updateRefundMethod(@PathVariable Long id, @PathVariable Long refundMethodId) {
        getService().updateRefundMethod(id, refundMethodId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/refund-reason/{refundReasonId}")
    public ApiResponse<?> updateRefundReason(@PathVariable Long id, @PathVariable Long refundReasonId) {
        getService().updateRefundReason(id, refundReasonId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/refund-status/{refundStatusId}")
    public ApiResponse<?> updateRefundStatus(@PathVariable Long id, @PathVariable Long refundStatusId) {
        getService().updateRefundStatus(id, refundStatusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
