package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    @Modifying
    @Query(value = """
                       UPDATE course
                          SET status_id = :statusId
                          WHERE id = :id
                       AND marked_as_deleted=false
            """, nativeQuery = true)
    void updateCourseStatus(Long id, Long statusId);
}
