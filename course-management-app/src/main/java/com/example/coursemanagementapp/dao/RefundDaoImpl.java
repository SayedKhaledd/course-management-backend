package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.RefundRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class RefundDaoImpl implements RefundDao {

    private final RefundRepo refundRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    @Override
    public RefundRepo getRepo() {
        return refundRepo;
    }

    @Override
    public void updateRefundedAmount(Long id, Double refundedAmount) {
        log.info("RefundDao: updateAmount() - was called");
        getRepo().updateRefundedAmount(id, refundedAmount);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateRefundDate(Long id, LocalDateTime refundDate) {
        log.info("RefundDao: updateRefundDate() - was called");
        getRepo().updateRefundDate(id, refundDate);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }


    @Override
    public void updateFirstExplanation(Long id, String firstExplanation) {
        log.info("RefundDao: updateFirstExplanation() - was called");
        getRepo().updateFirstExplanation(id, firstExplanation);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateSecondExplanation(Long id, String secondExplanation) {
        log.info("RefundDao: updateSecondExplanation() - was called");
        getRepo().updateSecondExplanation(id, secondExplanation);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }


    @Override
    public void updateRefundReason(Long id, Long refundReasonId) {
        log.info("RefundDao: updateRefundReason() - was called");
        getRepo().updateRefundReason(id, refundReasonId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateRefundMethod(Long id, Long refundMethodId) {
        log.info("RefundDao: updateRefundMethod() - was called");
        getRepo().updateRefundMethod(id, refundMethodId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateRefundStatus(Long id, Long refundStatusId) {
        log.info("RefundDao: updateRefundStatus() - was called");
        getRepo().updateRefundStatus(id, refundStatusId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("RefundDao: updateIsReceived() - was called");
        getRepo().updateIsReceived(id, isReceived);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
