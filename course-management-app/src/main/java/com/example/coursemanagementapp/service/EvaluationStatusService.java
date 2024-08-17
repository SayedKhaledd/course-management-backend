package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.EvaluationStatus;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.transformer.EvaluationStatusTransformer;
import com.example.coursemanagementapp.dao.EvaluationStatusDao;
import com.example.backendcoreservice.service.AbstractService;

public interface EvaluationStatusService extends AbstractService<EvaluationStatus, EvaluationStatusDto, EvaluationStatusTransformer, EvaluationStatusDao> {

}
