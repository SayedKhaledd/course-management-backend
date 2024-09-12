package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrollmentDaoImpl implements EnrollmentDao {

    private final EnrollmentRepo enrollmentRepo;

    @Override
    public EnrollmentRepo getRepo() {
        return enrollmentRepo;
    }


}
