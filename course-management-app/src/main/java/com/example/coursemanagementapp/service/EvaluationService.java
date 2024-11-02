package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EvaluationDao;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.model.Evaluation;
import com.example.coursemanagementapp.transformer.EvaluationTransformer;

import java.util.List;

public interface EvaluationService extends AbstractService<Evaluation, EvaluationDto, EvaluationTransformer, EvaluationDao> {

    List<EvaluationDto> findAllByClientId(Long clientId);

    List<EvaluationDto> findAllByCourseId(Long courseId);

    void updateExamName(EvaluationDto evaluationDto, Long id);

    void updateEvaluationStatus(Long id, Long evaluationStatusId);
}
