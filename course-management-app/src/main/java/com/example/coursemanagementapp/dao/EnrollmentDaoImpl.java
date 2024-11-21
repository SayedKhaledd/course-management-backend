package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.EntityManagerDao;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;
import com.example.coursemanagementapp.dto.search.EnrollmentSearchDto;
import com.example.coursemanagementapp.model.Enrollment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class EnrollmentDaoImpl implements EnrollmentDao {

    private final EnrollmentRepo enrollmentRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;
    private final EntityManagerDao entityManagerDao;

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
    public Page<Enrollment> findAllPaginatedAndFiltered(PaginationRequest<EnrollmentSearchDto> paginationRequest) {
        log.info("EnrollmentDao: findAllPaginatedAndFiltered() - was called");
        EnrollmentSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));

        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);
    }

    @Override
    public void updateAmountPaid(Long id, Double amountPaid) {
        log.info("EnrollmentDao: updateAmountPaid() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "amountPaid", amountPaid, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateRemainingAmount(Long id, Double remainingAmount) {
        log.info("EnrollmentDao: updateRemainingAmount() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "remainingAmount", remainingAmount, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDiscount(Long id, Double discount) {
        log.info("EnrollmentDao: updateDiscount() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "discount", discount, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateCurrency(Long id, String currency) {
        log.info("EnrollmentDao: updateCurrency() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "currency", currency, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePayInInstallments(Long id, Boolean payInInstallments) {
        log.info("EnrollmentDao: updatePayInInstallments() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "payInInstallments", payInInstallments, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateInsideEgypt(Long id, Boolean insideEgypt) {
        log.info("EnrollmentDao: updateInsideEgypt() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "insideEgypt", insideEgypt, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateReview(Long id, String review) {
        log.info("EnrollmentDao: updateReview() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "review", review, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateRating(Long id, String rating) {
        log.info("EnrollmentDao: updateRating() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "rating", rating, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDescription(Long id, String description) {
        log.info("EnrollmentDao: updateDescription() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "description", description, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentStatus(Long id, Long paymentStatusId) {
        log.info("EnrollmentDao: updatePaymentStatus() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "paymentStatusId", paymentStatusId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("EnrollmentDao: updatePaymentMethod() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "paymentMethodId", paymentMethodId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateActionTaken(Long id, Long actionTakenId) {
        log.info("EnrollmentDao: updateActionTaken() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "actionTakenId", actionTakenId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateReferralSource(Long id, Long referralSourceId) {
        log.info("EnrollmentDao: updateReferralSource() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "referralSourceId", referralSourceId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateClient(Long id, Long clientId) {
        log.info("EnrollmentDao: updateClient() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "clientId", clientId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateCourse(Long id, Long courseId) {
        log.info("EnrollmentDao: updateCourse() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "courseId", courseId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("EnrollmentDao: updateIsReceived() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "isReceived", isReceived, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateTotalAmount(Long id, Double totalAmount) {
        log.info("EnrollmentDao: updateTotalAmount() - was called");
        entityManagerDao.updateQuery(Enrollment.class.getSimpleName(), id, "totalAmount", totalAmount, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
