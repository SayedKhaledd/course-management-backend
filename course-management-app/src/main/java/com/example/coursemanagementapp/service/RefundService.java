package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.RefundDao;
import com.example.coursemanagementapp.dto.RefundDto;
import com.example.coursemanagementapp.model.Refund;
import com.example.coursemanagementapp.transformer.RefundTransformer;

public interface RefundService extends AbstractService<Refund, RefundDto, RefundTransformer, RefundDao> {

    void updateAmount(Long id, RefundDto dto);

    void updateRefundDate(Long id, RefundDto dto);

    void updateIsConfirmed(Long id, Boolean isConfirmed);

    void updateExplanation(Long id, RefundDto dto);

    void updateRefundReason(Long id, Long refundReasonId);

    void updatePaymentMethod(Long id, Long paymentMethodId);
}
