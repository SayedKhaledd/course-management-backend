package com.example.coursemanagementapp.dao;

import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;
import com.example.coursemanagementapp.model.Enrollment;

import java.util.List;

public interface EnrollmentDao extends AbstractDao<Enrollment, EnrollmentRepo> {

    List<Enrollment> findAllByClientId(Long clientId);
}
