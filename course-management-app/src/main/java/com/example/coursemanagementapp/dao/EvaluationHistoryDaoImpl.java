package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EvaluationHistoryRepo;
import com.example.coursemanagementapp.model.EvaluationHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EvaluationHistoryDaoImpl implements EvaluationHistoryDao {

    private final EvaluationHistoryRepo evaluationhistoryRepo;

    @Override
    public EvaluationHistoryRepo getRepo() {
        return evaluationhistoryRepo;
    }

    @Override
    public List<EvaluationHistory> findAllByEvaluationIdAndFieldName(Long evaluationId, String fieldName) {
        log.info("EvaluationHistoryDaoImpl: findAllByEvaluationIdAndFieldName() called");
        return getRepo().findAllByEvaluationIdAndFieldName(evaluationId, fieldName);
    }
}
