package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.EnrollmentHistory;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.transformer.EnrollmentHistoryTransformer;
import com.example.coursemanagementapp.dao.EnrollmentHistoryDao;
import com.example.backendcoreservice.service.AbstractService;

public interface EnrollmentHistoryService extends AbstractService<EnrollmentHistory, EnrollmentHistoryDto, EnrollmentHistoryTransformer, EnrollmentHistoryDao> {

}
