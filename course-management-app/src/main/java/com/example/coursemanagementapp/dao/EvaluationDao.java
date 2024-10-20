package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.EvaluationRepo;
import com.example.coursemanagementapp.model.Evaluation;

import java.util.List;

public interface EvaluationDao extends AbstractDao<Evaluation, EvaluationRepo> {

    List<Evaluation> findAllByClientId(Long clientId);

    List<Evaluation> findAllByCourseId(Long courseId);

    void updateExamName(Long id, String examName);

    void updateEvaluationStatus(Long id, Long evaluationStatusId);
}
