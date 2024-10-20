package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.CourseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseHistoryRepo extends JpaRepository<CourseHistory, Long> {

    List<CourseHistory> findAllByCourseIdAndFieldName(Long courseId, String fieldName);
}
