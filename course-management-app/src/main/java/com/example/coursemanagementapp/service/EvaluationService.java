package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EvaluationDao;
import com.example.coursemanagementapp.dto.EvaluationDto;
import com.example.coursemanagementapp.model.Evaluation;
import com.example.coursemanagementapp.transformer.EvaluationTransformer;

public interface EvaluationService extends AbstractService<Evaluation, EvaluationDto, EvaluationTransformer, EvaluationDao> {

}
