package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.EvaluationStatusRepo;

@Component
@AllArgsConstructor
public class EvaluationStatusDaoImpl implements EvaluationStatusDao {

    private final EvaluationStatusRepo evaluationstatusRepo;

    @Override
    public EvaluationStatusRepo getRepo() {
        return evaluationstatusRepo;
    }


}
