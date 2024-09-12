package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EnrollmentHistoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnrollmentHistoryDaoImpl implements EnrollmentHistoryDao {

    private final EnrollmentHistoryRepo enrollmenthistoryRepo;

    @Override
    public EnrollmentHistoryRepo getRepo() {
        return enrollmenthistoryRepo;
    }


}
