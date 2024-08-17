package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.EvaluationStatusDao;
import com.example.coursemanagementapp.transformer.EvaluationStatusTransformer;

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
    



}
