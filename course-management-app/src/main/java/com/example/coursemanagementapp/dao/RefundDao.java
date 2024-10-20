package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.RefundRepo;
import com.example.coursemanagementapp.model.Refund;

import java.time.LocalDateTime;

public interface RefundDao extends AbstractDao<Refund, RefundRepo> {

    void updateAmount(Long id, Double amount);

    void updateRefundDate(Long id, LocalDateTime refundDate);

    void updateIsConfirmed(Long id, Boolean isConfirmed);

    void updateExplanation(Long id, String explanation);

    void updateRefundReason(Long id, Long refundReasonId);

    void updatePaymentMethod(Long id, Long paymentMethodId);


}
