package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.EnrollmentHistoryRepo;
import com.example.coursemanagementapp.model.EnrollmentHistory;

import java.util.List;

public interface EnrollmentHistoryDao extends AbstractDao<EnrollmentHistory, EnrollmentHistoryRepo> {

    List<EnrollmentHistory> findAllByEnrollmentIdAndFieldName(Long enrollmentId, String fieldName);
}
