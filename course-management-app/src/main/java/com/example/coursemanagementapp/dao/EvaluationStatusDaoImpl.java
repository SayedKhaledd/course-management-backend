package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EvaluationStatusRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluationStatusDaoImpl implements EvaluationStatusDao {

    private final EvaluationStatusRepo evaluationstatusRepo;

    @Override
    public EvaluationStatusRepo getRepo() {
        return evaluationstatusRepo;
    }


}
