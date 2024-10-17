package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

    List<Enrollment> findAllByClientId(Long clientId);
}
