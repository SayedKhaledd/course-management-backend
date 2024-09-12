package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EnrollmentHistoryDao;
import com.example.coursemanagementapp.dto.EnrollmentHistoryDto;
import com.example.coursemanagementapp.model.EnrollmentHistory;
import com.example.coursemanagementapp.transformer.EnrollmentHistoryTransformer;

public interface EnrollmentHistoryService extends AbstractService<EnrollmentHistory, EnrollmentHistoryDto, EnrollmentHistoryTransformer, EnrollmentHistoryDao> {

}
