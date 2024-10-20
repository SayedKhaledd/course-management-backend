package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.config.AuditAwareImpl;
import com.example.coursemanagementapp.dao.repo.EvaluationRepo;
import com.example.coursemanagementapp.model.Evaluation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class EvaluationDaoImpl implements EvaluationDao {

    private final EvaluationRepo evaluationRepo;
    @Qualifier("auditAwareImpl")
    private final AuditAwareImpl auditAware;

    @Override
    public EvaluationRepo getRepo() {
        return evaluationRepo;
    }

    @Override
    public List<Evaluation> findAllByClientId(Long clientId) {
        return getRepo().findAllByClientId(clientId);
    }

    @Override
    public List<Evaluation> findAllByCourseId(Long courseId) {
        return getRepo().findAllByCourseId(courseId);
    }

    @Override
    public void updateExamName(Long id, String examName) {
        getRepo().updateExamName(id, examName);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());

    }

    @Override
    public void updateEvaluationStatus(Long id, Long evaluationStatusId) {

        getRepo().updateEvaluationStatus(id, evaluationStatusId);
        getRepo().updateModifiedDateAndModifiedBy(id, auditAware.getCurrentAuditor().get(), LocalDateTime.now());
    }
}
