package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.CourseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStatusRepo extends JpaRepository<CourseStatus, Long> {

    CourseStatus findByStatus(com.example.coursemanagementapp.enums.CourseStatus status);
}
