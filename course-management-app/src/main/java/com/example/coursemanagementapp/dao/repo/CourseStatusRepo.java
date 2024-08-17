package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.CourseStatus;

import java.util.List;

@Repository
public interface CourseStatusRepo extends JpaRepository<CourseStatus, Long> {

    List<CourseStatus> findAllByMarkedAsDeletedFalse();
}
