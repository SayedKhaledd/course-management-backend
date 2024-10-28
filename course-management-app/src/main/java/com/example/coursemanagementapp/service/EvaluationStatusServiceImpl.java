package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.EvaluationStatusDao;
import com.example.coursemanagementapp.model.EvaluationStatus;
import com.example.coursemanagementapp.transformer.EvaluationStatusTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EvaluationStatusServiceImpl implements EvaluationStatusService {

    private final EvaluationStatusDao evaluationstatusDao;
    private final EvaluationStatusTransformer evaluationstatusTransformer;

    @Override
    public EvaluationStatusDao getDao() {
        return evaluationstatusDao;
    }

    @Override
    public EvaluationStatusTransformer getTransformer() {
        return evaluationstatusTransformer;
    }


    @Override
    public String getEntityName() {
        return EvaluationStatus.class.getSimpleName();
    }
}
