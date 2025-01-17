package com.example.coursemanagementapp.dao;


import com.example.backendcoreservice.dao.EntityManagerDao;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.EvaluationRepo;
import com.example.coursemanagementapp.dto.search.EvaluationSearchDto;
import com.example.coursemanagementapp.dto.search.InstallmentSearchDto;
import com.example.coursemanagementapp.model.Evaluation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class EvaluationDaoImpl implements EvaluationDao {

    private final EvaluationRepo evaluationRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;
    private final EntityManagerDao entityManagerDao;

    @Override
    public EvaluationRepo getRepo() {
        return evaluationRepo;
    }

    @Override
    public Page<Evaluation> findAllPaginatedAndFiltered(PaginationRequest<EvaluationSearchDto> paginationRequest) {
        log.info("EvaluationDao: findAllPaginatedAndFiltered - was called with paginationRequest: {}", paginationRequest);
        EvaluationSearchDto criteria = paginationRequest.getCriteria();
        if (criteria == null)
            return getRepo().findAll(getPageRequest(paginationRequest));
        return getRepo().findAllFilteredAndPaginated(getPageRequest(paginationRequest), criteria);

    }

    @Override
    public void updateExamName(Long id, String examName) {
        log.info("EvaluationDao: updateExamName() - was called");
        entityManagerDao.updateQuery(Evaluation.class.getSimpleName(), id, "examName", examName, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

    @Override
    public void updateEvaluationStatus(Long id, Long evaluationStatusId) {
        log.info("EvaluationDao: updateEvaluationStatus() - was called");
        entityManagerDao.updateQuery(Evaluation.class.getSimpleName(), id, "evaluationStatusId", evaluationStatusId, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }

}
