package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EvaluationRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EvaluationDaoImpl implements EvaluationDao {

    private final EvaluationRepo evaluationRepo;

    @Override
    public EvaluationRepo getRepo() {
        return evaluationRepo;
    }


}
