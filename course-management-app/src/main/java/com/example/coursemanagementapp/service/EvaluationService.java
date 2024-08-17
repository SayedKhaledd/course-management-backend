package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.Evaluation;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.transformer.EvaluationTransformer;
import com.example.coursemanagementapp.dao.EvaluationDao;
import com.example.backendcoreservice.service.AbstractService;

public interface EvaluationService extends AbstractService<Evaluation, EvaluationDto, EvaluationTransformer, EvaluationDao> {

}
