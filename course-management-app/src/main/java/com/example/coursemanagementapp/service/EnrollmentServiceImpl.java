package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.EnrollmentDao;
import com.example.coursemanagementapp.transformer.EnrollmentTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentDao enrollmentDao;
    private final EnrollmentTransformer enrollmentTransformer;

    @Override
    public EnrollmentDao getDao() {
        return enrollmentDao;
    }

    @Override
    public EnrollmentTransformer getTransformer() {
        return enrollmentTransformer;
    }


}
