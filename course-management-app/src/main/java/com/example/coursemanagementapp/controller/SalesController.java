package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.dto.search.SalesSearchDto;
import com.example.coursemanagementapp.enums.PaymentType;
import com.example.coursemanagementapp.service.SalesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/sales")
@AllArgsConstructor
public class SalesController implements AbstractController<SalesService, SalesDto> {
    private final SalesService salesService;
    private final ApiResponseBuilder<SalesDto> apiResponseBuilder;

    @Override
    public SalesService getService() {
        return salesService;
    }

    @Override
    public ApiResponseBuilder<SalesDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')  OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<SalesDto>> findPaginatedAndFiltered(@RequestBody PaginationRequest<SalesSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }

    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')  OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/payment-type/{paymentType}/is-received/{isReceived}")
    public ApiResponse<?> updateIsReceivedByPaymentType(@PathVariable Long id, @PathVariable PaymentType paymentType, @PathVariable Boolean isReceived) {
        getService().updateIsReceivedByPaymentType(id, paymentType, isReceived);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PreAuthorize("hasAuthority('SUPER_ADMIN') OR hasAuthority( 'ADMIN') OR hasAuthority( 'ACCOUNTANT')  OR hasAuthority( 'CUSTOMER_SERVICE')")
    @PatchMapping("/{id}/payment-type/{paymentType}/payment-status/{paymentStatusId}")
    public ApiResponse<?> updatePaymentStatus(@PathVariable Long id, @PathVariable PaymentType paymentType, @PathVariable Long paymentStatusId) {
        getService().updatePaymentStatusByPaymentType(id, paymentType, paymentStatusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
