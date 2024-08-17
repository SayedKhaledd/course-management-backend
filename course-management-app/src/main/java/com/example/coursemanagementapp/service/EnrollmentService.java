package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.model.Enrollment;
import com.example.coursemanagementapp.dto.EnrollmentDto;
import com.example.coursemanagementapp.transformer.EnrollmentTransformer;
import com.example.coursemanagementapp.dao.EnrollmentDao;
import com.example.backendcoreservice.service.AbstractService;

public interface EnrollmentService extends AbstractService<Enrollment, EnrollmentDto, EnrollmentTransformer, EnrollmentDao> {

}
