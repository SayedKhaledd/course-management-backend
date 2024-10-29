package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.RefundTransformer;

public interface RefundService extends AbstractService<Refund, RefundDto, RefundTransformer, RefundDao> {

    void updateRefundedAmount(Long id, RefundDto dto);

    void updateRefundDate(Long id, RefundDto dto);

    void updateFirstExplanation(Long id, RefundDto dto);

    void updateSecondExplanation(Long id, RefundDto dto);

    void updateRefundReason(Long id, Long refundReasonId);

    void updateRefundMethod(Long id, Long paymentMethodId);

    void updateRefundStatus(Long id, Long refundStatusId);

    void updateIsReceived(Long id, Boolean isReceived);
}
