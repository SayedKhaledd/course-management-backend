package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;
import com.example.coursemanagementapp.model.Enrollment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class EnrollmentDaoImpl implements EnrollmentDao {

    private final EnrollmentRepo enrollmentRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    @Override
    public EnrollmentRepo getRepo() {
        return enrollmentRepo;
    }

    @Override
    public List<Enrollment> findAllByClientId(Long clientId) {
        log.info("EnrollmentDao: findAllByClientId() called with clientId: {}", clientId);
        return getRepo().findAllByClientId(clientId);
    }

    @Override
    public List<Enrollment> findAllByCourseId(Long courseId) {
        log.info("EnrollmentDao: findAllByCourseId() called with courseId: {}", courseId);
        return getRepo().findAllByCourseId(courseId);
    }

    @Override
    public Enrollment findByClientIdAndCourseId(Long clientId, Long courseId) {
        log.info("EnrollmentDao: findByClientIdAndCourseId() called with clientId: {} and courseId: {}", clientId, courseId);
        return getRepo().findByClientIdAndCourseId(clientId, courseId);
    }

    @Override
    public void updateAmountPaid(Long id, Double amountPaid) {
        log.info("EnrollmentDao: updateAmountPaid() - was called");
        getRepo().updateAmountPaid(id, amountPaid);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateRemainingAmount(Long id, Double remainingAmount) {
        log.info("EnrollmentDao: updateRemainingAmount() - was called");
        getRepo().updateRemainingAmount(id, remainingAmount);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDiscount(Long id, Double discount) {
        log.info("EnrollmentDao: updateDiscount() - was called");
        getRepo().updateDiscount(id, discount);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateCurrency(Long id, String currency) {
        log.info("EnrollmentDao: updateCurrency() - was called");
        getRepo().updateCurrency(id, currency);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePayInInstallments(Long id, Boolean payInInstallments) {
        log.info("EnrollmentDao: updatePayInInstallments() - was called");
        getRepo().updatePayInInstallments(id, payInInstallments);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateInsideEgypt(Long id, Boolean insideEgypt) {
        log.info("EnrollmentDao: updateInsideEgypt() - was called");
        getRepo().updateInsideEgypt(id, insideEgypt);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateReview(Long id, String review) {
        log.info("EnrollmentDao: updateReview() - was called");
        getRepo().updateReview(id, review);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateRating(Long id, String rating) {
        log.info("EnrollmentDao: updateRating() - was called");
        getRepo().updateRating(id, rating);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDescription(Long id, String description) {
        log.info("EnrollmentDao: updateDescription() - was called");
        getRepo().updateDescription(id, description);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentStatus(Long id, Long paymentStatusId) {
        log.info("EnrollmentDao: updatePaymentStatus() - was called");
        getRepo().updatePaymentStatus(id, paymentStatusId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("EnrollmentDao: updatePaymentMethod() - was called");
        getRepo().updatePaymentMethod(id, paymentMethodId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateActionTaken(Long id, Long actionTakenId) {
        log.info("EnrollmentDao: updateActionTaken() - was called");
        getRepo().updateActionTaken(id, actionTakenId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateReferralSource(Long id, Long referralSourceId) {
        log.info("EnrollmentDao: updateReferralSource() - was called");
        getRepo().updateReferralSource(id, referralSourceId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateClient(Long id, Long clientId) {
        log.info("EnrollmentDao: updateClient() - was called");
        getRepo().updateClient(id, clientId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateCourse(Long id, Long courseId) {
        log.info("EnrollmentDao: updateCourse() - was called");
        getRepo().updateCourse(id, courseId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("EnrollmentDao: updateIsReceived() - was called");
        getRepo().updateIsReceived(id, isReceived);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateTotalAmount(Long id, Double totalAmount) {
        log.info("EnrollmentDao: updateTotalAmount() - was called");
        getRepo().updateTotalAmount(id, totalAmount);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
