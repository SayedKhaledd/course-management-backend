package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.EnrollmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentHistoryRepo extends JpaRepository<EnrollmentHistory, Long> {

    List<EnrollmentHistory> findAllByEnrollmentIdAndFieldName(Long enrollmentId, String fieldName);
}
