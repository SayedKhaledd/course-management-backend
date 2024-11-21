package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.SalesDao;
import com.example.coursemanagementapp.dto.SalesDto;
import com.example.coursemanagementapp.dto.search.SalesSearchDto;
import com.example.coursemanagementapp.enums.PaymentType;
import com.example.coursemanagementapp.model.Sales;
import com.example.coursemanagementapp.transformer.SalesTransformer;

public interface SalesService extends AbstractService<Sales, SalesDto, SalesTransformer, SalesDao> {
    PaginationResponse<SalesDto> findAllPaginatedAndFiltered(PaginationRequest<SalesSearchDto> paginationRequest);

    void updateIsReceivedByPaymentType(Long id, PaymentType paymentType, Boolean isReceived);

    void updatePaymentStatusByPaymentType(Long entityId, PaymentType paymentType, Long paymentStatusId);
}
