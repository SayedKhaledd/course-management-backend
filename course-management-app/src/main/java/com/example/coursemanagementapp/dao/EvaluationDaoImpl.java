package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.EvaluationRepo;

@Component
@AllArgsConstructor
public class EvaluationDaoImpl implements EvaluationDao {

    private final EvaluationRepo evaluationRepo;

    @Override
    public EvaluationRepo getRepo() {
        return evaluationRepo;
    }


}
