package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EvaluationStatusDao;
import com.example.coursemanagementapp.dto.EvaluationStatusDto;
import com.example.coursemanagementapp.model.EvaluationStatus;
import com.example.coursemanagementapp.transformer.EvaluationStatusTransformer;

public interface EvaluationStatusService extends AbstractService<EvaluationStatus, EvaluationStatusDto, EvaluationStatusTransformer, EvaluationStatusDao> {

}
