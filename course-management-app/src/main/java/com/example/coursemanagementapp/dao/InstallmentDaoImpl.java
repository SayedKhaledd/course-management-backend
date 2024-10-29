package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.InstallmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class InstallmentDaoImpl implements InstallmentDao {

    private final InstallmentRepo installmentRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    @Override
    public InstallmentRepo getRepo() {
        return installmentRepo;
    }

    @Override
    public void updateAmount(Long id, Double amount) {
        log.info("InstallmentDao: updateAmount() - was called");
        getRepo().updateAmount(id, amount);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDueDate(Long id, LocalDateTime dueDate) {
        log.info("InstallmentDao: updateDueDate() - was called");
        getRepo().updateDueDate(id, dueDate);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updatePaymentDate(Long id, LocalDateTime paymentDate) {
        log.info("InstallmentDao: updatePaymentDate() - was called");
        getRepo().updatePaymentDate(id, paymentDate);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentStatus(Long id, Long paymentStatusId) {
        log.info("InstallmentDao: updatePaymentStatus() - was called");
        getRepo().updatePaymentStatus(id, paymentStatusId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("InstallmentDao: updatePaymentMethod() - was called");
        getRepo().updatePaymentMethod(id, paymentMethodId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("InstallmentDao: updateIsReceived() - was called");
        getRepo().updateIsReceived(id, isReceived);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
