package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.EvaluationHistoryDao;
import com.example.coursemanagementapp.dto.EvaluationHistoryDto;
import com.example.coursemanagementapp.transformer.EvaluationHistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EvaluationHistoryServiceImpl implements EvaluationHistoryService {

    private final EvaluationHistoryDao evaluationhistoryDao;
    private final EvaluationHistoryTransformer evaluationhistoryTransformer;

    @Override
    public EvaluationHistoryDao getDao() {
        return evaluationhistoryDao;
    }

    @Override
    public EvaluationHistoryTransformer getTransformer() {
        return evaluationhistoryTransformer;
    }


    @Override
    public List<EvaluationHistoryDto> findAllByEvaluationIdAndFieldName(Long evaluationId, String fieldName) {
        log.info("EvaluationHistoryServiceImpl: findAllByEvaluationIdAndFieldName() called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByEvaluationIdAndFieldName(evaluationId, fieldName));
    }


}
