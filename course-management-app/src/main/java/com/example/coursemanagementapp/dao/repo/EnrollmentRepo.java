package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Long> {

}
