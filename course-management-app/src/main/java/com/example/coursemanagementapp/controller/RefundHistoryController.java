package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.RefundHistoryDto;
import com.example.coursemanagementapp.service.RefundHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/refundhistory")
@AllArgsConstructor
public class RefundHistoryController implements AbstractController<RefundHistoryService, RefundHistoryDto> {

    private final RefundHistoryService refundhistoryService;
    private final ApiResponseBuilder<RefundHistoryDto> apiResponseBuilder;


    @Override
    public RefundHistoryService getService() {
        return refundhistoryService;
    }

    @Override
    public ApiResponseBuilder<RefundHistoryDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }


    @GetMapping("/refund/{refundId}/field/{fieldName}")
    public ApiResponse<List<RefundHistoryDto>> findByRefundIdAndFieldName(@PathVariable Long refundId, @PathVariable String fieldName) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllByRefundIdAndFieldName(refundId, fieldName));
    }


}
