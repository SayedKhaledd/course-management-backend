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
    public void updateAmount(Long id, Double amount) {
        log.info("RefundDao: updateAmount() - was called");
        getRepo().updateAmount(id, amount);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateRefundDate(Long id, LocalDateTime refundDate) {
        log.info("RefundDao: updateRefundDate() - was called");
        getRepo().updateRefundDate(id, refundDate);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateIsConfirmed(Long id, Boolean isConfirmed) {
        log.info("RefundDao: updateIsConfirmed() - was called");
        getRepo().updateIsConfirmed(id, isConfirmed);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateExplanation(Long id, String explanation) {
        log.info("RefundDao: updateExplanation() - was called");
        getRepo().updateExplanation(id, explanation);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateRefundReason(Long id, Long refundReasonId) {
        log.info("RefundDao: updateRefundReason() - was called");
        getRepo().updateRefundReason(id, refundReasonId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("RefundDao: updatePaymentMethod() - was called");
        getRepo().updatePaymentMethod(id, paymentMethodId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }
}
