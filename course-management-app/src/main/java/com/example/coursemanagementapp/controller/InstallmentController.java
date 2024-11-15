package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.dto.InstallmentDto;
import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.service.InstallmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/api/installment")
@AllArgsConstructor
public class InstallmentController implements AbstractController<InstallmentService, InstallmentDto> {

    private final InstallmentService installmentService;
    private final ApiResponseBuilder<InstallmentDto> apiResponseBuilder;


    @Override
    public InstallmentService getService() {
        return installmentService;
    }

    @Override
    public ApiResponseBuilder<InstallmentDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @GetMapping("/all")
    public ApiResponse<?> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<InstallmentDto>> findAllPaginatedAndFiltered(@RequestBody @Valid PaginationRequest<InstallmentSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PostMapping()
    public ApiResponse<InstallmentDto> create(@Validated({InstallmentDto.Create.class}) @RequestBody InstallmentDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }
    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/amount")
    public ApiResponse<?> updateAmount(@PathVariable Long id, @RequestBody @Validated(InstallmentDto.UpdateAmount.class) InstallmentDto dto) {
        getService().updateAmount(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/due-date")
    public ApiResponse<?> updateDueDate(@PathVariable Long id, @RequestBody @Validated(InstallmentDto.UpdateDueDate.class) InstallmentDto dto) {
        getService().updateDueDate(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/payment-date")
    public ApiResponse<?> updatePaymentDate(@PathVariable Long id, @RequestBody @Validated(InstallmentDto.UpdatePaymentDate.class) InstallmentDto dto) {
        getService().updatePaymentDate(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/payment-status/{paymentStatusId}")
    public ApiResponse<?> updatePaymentStatus(@PathVariable Long id, @PathVariable Long paymentStatusId) {
        getService().updatePaymentStatus(id, paymentStatusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/payment-method/{paymentMethodId}")
    public ApiResponse<?> updatePaymentMethod(@PathVariable Long id, @PathVariable Long paymentMethodId) {
        getService().updatePaymentMethod(id, paymentMethodId);
        return getApiResponseBuilder().buildSuccessResponse();
    }
    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN')")
    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
