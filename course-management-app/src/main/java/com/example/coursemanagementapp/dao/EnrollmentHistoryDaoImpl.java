package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.EnrollmentHistoryRepo;
import com.example.coursemanagementapp.model.EnrollmentHistory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EnrollmentHistoryDaoImpl implements EnrollmentHistoryDao {

    private final EnrollmentHistoryRepo enrollmenthistoryRepo;

    @Override
    public EnrollmentHistoryRepo getRepo() {
        return enrollmenthistoryRepo;
    }


    @Override
    public List<EnrollmentHistory> findAllByEnrollmentIdAndFieldName(Long enrollmentId, String fieldName) {
        return getRepo().findAllByEnrollmentIdAndFieldName(enrollmentId, fieldName);
    }
}
