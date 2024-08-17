package com.example.coursemanagementapp.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.example.coursemanagementapp.dao.EnrollmentHistoryDao;
import com.example.coursemanagementapp.transformer.EnrollmentHistoryTransformer;

@Slf4j
@Service
@AllArgsConstructor
public class EnrollmentHistoryServiceImpl implements EnrollmentHistoryService {

    private final EnrollmentHistoryDao enrollmenthistoryDao;
    private final EnrollmentHistoryTransformer enrollmenthistoryTransformer;

    @Override
    public EnrollmentHistoryDao getDao() {
        return enrollmenthistoryDao;
    }

    @Override
    public EnrollmentHistoryTransformer getTransformer() {
        return enrollmenthistoryTransformer;
    }
    



}