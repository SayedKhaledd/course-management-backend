package com.example.coursemanagementapp.dao;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.dao.repo.EnrollmentHistoryRepo;

@Component
@AllArgsConstructor
public class EnrollmentHistoryDaoImpl implements EnrollmentHistoryDao {

    private final EnrollmentHistoryRepo enrollmenthistoryRepo;

    @Override
    public EnrollmentHistoryRepo getRepo() {
        return enrollmenthistoryRepo;
    }


}
