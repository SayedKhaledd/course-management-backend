package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.EnrollmentDao;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.transformer.EnrollmentTransformer;

import java.util.List;

public interface EnrollmentService extends AbstractService<Enrollment, EnrollmentDto, EnrollmentTransformer, EnrollmentDao> {

    List<EnrollmentDto> findAllByClientId(Long clientId);
}
