package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EnrollmentRepo;
import com.example.coursemanagementapp.model.Enrollment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EnrollmentDaoImpl implements EnrollmentDao {

    private final EnrollmentRepo enrollmentRepo;

    @Override
    public EnrollmentRepo getRepo() {
        return enrollmentRepo;
    }

    @Override
    public List<Enrollment> findAllByClientId(Long clientId) {
        log.info("EnrollmentDao: findAllByClientId() called with clientId: {}", clientId);
        return getRepo().findAllByClientId(clientId);
    }
}
