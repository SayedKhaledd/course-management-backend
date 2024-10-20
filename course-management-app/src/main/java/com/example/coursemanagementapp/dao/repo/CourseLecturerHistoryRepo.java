package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.CourseLecturerHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseLecturerHistoryRepo extends JpaRepository<CourseLecturerHistory, Long> {

    List<CourseLecturerHistory> findAllByCourseLecturerIdAndFieldName(Long courseLecturerId, String fieldName);

}
