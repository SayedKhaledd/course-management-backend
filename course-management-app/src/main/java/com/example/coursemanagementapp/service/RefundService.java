package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.dto.search.RefundSearchDto;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.RefundTransformer;

public interface RefundService extends AbstractService<Refund, RefundDto, RefundTransformer, RefundDao> {

    PaginationResponse<RefundDto> findAllPaginatedAndFiltered(PaginationRequest<RefundSearchDto> paginationRequest);

    void updateRefundedAmount(Long id, RefundDto dto);

    void updateRefundDate(Long id, RefundDto dto);

    void updateFirstExplanation(Long id, RefundDto dto);

    void updateSecondExplanation(Long id, RefundDto dto);

    void updateRefundReason(Long id, Long refundReasonId);

    void updateRefundMethod(Long id, Long refundMethodId);

    void updateRefundStatus(Long id, Long refundStatusId);

    void updateIsReceived(Long id, Boolean isReceived);

}
