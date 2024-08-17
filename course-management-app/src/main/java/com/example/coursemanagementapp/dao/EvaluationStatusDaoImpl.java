package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.EvaluationStatus;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.EvaluationStatusRepo;

import java.util.List;

@Component
@AllArgsConstructor
public class EvaluationStatusDaoImpl implements EvaluationStatusDao {

    private final EvaluationStatusRepo evaluationstatusRepo;

    @Override
    public EvaluationStatusRepo getRepo() {
        return evaluationstatusRepo;
    }

    @Override
    public List<EvaluationStatus> findAll() {
        return getRepo().findAllByMarkedAsDeletedFalse();
    }
}
