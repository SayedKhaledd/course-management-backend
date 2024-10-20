package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.EvaluationHistory;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.EvaluationHistoryRepo;

import java.util.List;

public interface EvaluationHistoryDao extends AbstractDao<EvaluationHistory, EvaluationHistoryRepo> {

    List<EvaluationHistory> findAllByEvaluationIdAndFieldName(Long evaluationId, String fieldName);
}
