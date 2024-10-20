package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.EvaluationHistory;
import com.example.coursemanagementapp.dto.EvaluationHistoryDto;
import com.example.coursemanagementapp.transformer.EvaluationHistoryTransformer;
import com.example.coursemanagementapp.dao.EvaluationHistoryDao;
import com.example.backendcoreservice.service.AbstractService;

import java.util.List;

public interface EvaluationHistoryService extends AbstractService<EvaluationHistory, EvaluationHistoryDto, EvaluationHistoryTransformer, EvaluationHistoryDao> {

    List<EvaluationHistoryDto> findAllByEvaluationIdAndFieldName(Long evaluationId, String fieldName);
}
