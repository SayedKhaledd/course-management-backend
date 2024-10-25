package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.service.RefundService;
import lombok.AllArgsConstructor;
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


    @GetMapping("/all")
    public ApiResponse<?> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }

    @PostMapping
    public ApiResponse<RefundDto> create(@Validated({RefundDto.Create.class, EnrollmentDto.Create.class}) @RequestBody RefundDto dto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(dto));
    }

    @PatchMapping("/{id}/amount")
    public ApiResponse<?> updateAmount(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateAmount.class) RefundDto dto) {
        getService().updateAmount(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/refund-date")
    public ApiResponse<?> updateRefundDate(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateRefundDate.class) RefundDto dto) {
        getService().updateRefundDate(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/is-confirmed/{isConfirmed}")
    public ApiResponse<?> updateIsConfirmed(@PathVariable Long id, @PathVariable Boolean isConfirmed) {
        getService().updateIsConfirmed(id, isConfirmed);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/explanation")
    public ApiResponse<?> updateExplanation(@PathVariable Long id, @RequestBody @Validated(RefundDto.UpdateExplanation.class) RefundDto dto) {
        getService().updateExplanation(id, dto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PatchMapping("/{id}/payment-method/{paymentMethodId}")
    public ApiResponse<?> updatePaymentMethod(@PathVariable Long id, @PathVariable Long paymentMethodId) {
        getService().updatePaymentMethod(id, paymentMethodId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/refund-reason/{refundReasonId}")
    public ApiResponse<?> updateRefundReason(@PathVariable Long id, @PathVariable Long refundReasonId) {
        getService().updateRefundReason(id, refundReasonId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
