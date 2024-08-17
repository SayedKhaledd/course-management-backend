package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;

@Component
@AllArgsConstructor
public class EnrollmentDaoImpl implements EnrollmentDao {

    private final EnrollmentRepo enrollmentRepo;

    @Override
    public EnrollmentRepo getRepo() {
        return enrollmentRepo;
    }


}
