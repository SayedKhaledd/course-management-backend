package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.CourseLecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseLecturerRepo extends JpaRepository<CourseLecturer, Long> {

}
