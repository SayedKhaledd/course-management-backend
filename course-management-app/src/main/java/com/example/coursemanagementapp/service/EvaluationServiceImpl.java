package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.EvaluationDao;
import com.example.coursemanagementapp.transformer.EvaluationTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationDao evaluationDao;
    private final EvaluationTransformer evaluationTransformer;

    @Override
    public EvaluationDao getDao() {
        return evaluationDao;
    }

    @Override
    public EvaluationTransformer getTransformer() {
        return evaluationTransformer;
    }
    



}
