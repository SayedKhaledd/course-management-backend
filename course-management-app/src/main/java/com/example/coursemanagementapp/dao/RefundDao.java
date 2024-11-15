package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.RefundRepo;
import com.example.coursemanagementapp.dto.search.RefundSearchDto;
import com.example.coursemanagementapp.model.Refund;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface RefundDao extends AbstractDao<Refund, RefundRepo> {

    Page<Refund> findAllPaginatedAndFiltered(PaginationRequest<RefundSearchDto> paginationRequest);

    void updateRefundedAmount(Long id, Double refundedAmount);

    void updateRefundDate(Long id, LocalDateTime refundDate);

    void updateFirstExplanation(Long id, String firstExplanation);

    void updateSecondExplanation(Long id, String secondExplanation);

    void updateRefundReason(Long id, Long refundReasonId);

    void updateRefundMethod(Long id, Long refundMethodId);

    void updateRefundStatus(Long id, Long refundStatusId);

    void updateIsReceived(Long id, Boolean isReceived);

}
