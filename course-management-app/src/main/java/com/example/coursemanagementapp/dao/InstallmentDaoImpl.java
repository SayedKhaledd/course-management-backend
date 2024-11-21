package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.dao.EntityManagerDaoImpl;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.InstallmentRepo;
import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.model.Installment;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class InstallmentDaoImpl implements InstallmentDao {

    private final InstallmentRepo installmentRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    private final EntityManagerDaoImpl entityManagerDao;

    @Override
    public InstallmentRepo getRepo() {
        return installmentRepo;
    }

    @Override
    public Page<Installment> findAllPaginatedAndFiltered(PaginationRequest<InstallmentSearchDto> paginationRequest) {
        InstallmentSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));
        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);
    }

    @Override
    public void updateAmount(Long id, Double amount) {
        log.info("InstallmentDao: updateAmount() - was called");
        entityManagerDao.updateQuery(Installment.class.getSimpleName(), id, "amount", amount, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateDueDate(Long id, LocalDateTime dueDate) {
        log.info("InstallmentDao: updateDueDate() - was called");
        entityManagerDao.updateQuery(Installment.class.getSimpleName(), id, "dueDate", dueDate, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentDate(Long id, LocalDateTime paymentDate) {
        log.info("InstallmentDao: updatePaymentDate() - was called");
        entityManagerDao.updateQuery(Installment.class.getSimpleName(), id, "paymentDate", paymentDate, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentStatus(Long id, Long paymentStatusId) {
        log.info("InstallmentDao: updatePaymentStatus() - was called");
        entityManagerDao.updateQuery(Installment.class.getSimpleName(), id, "paymentStatusId", paymentStatusId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updatePaymentMethod(Long id, Long paymentMethodId) {
        log.info("InstallmentDao: updatePaymentMethod() - was called");
        entityManagerDao.updateQuery(Installment.class.getSimpleName(), id, "paymentMethodId", paymentMethodId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateIsReceived(Long id, Boolean isReceived) {
        log.info("InstallmentDao: updateIsReceived() - was called");
        entityManagerDao.updateQuery(Installment.class.getSimpleName(), id, "isReceived", isReceived, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
