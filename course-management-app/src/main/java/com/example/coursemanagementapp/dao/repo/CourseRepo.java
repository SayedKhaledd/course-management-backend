package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

    @Query(value = "SELECT * FROM course c WHERE c.marked_as_deleted = :markedAsDeleted", nativeQuery = true)
    Page<Course> findAllByMarkedAsDeleted(Pageable pageRequest, Boolean markedAsDeleted);

//    Page<Course> findAllFilteredAndPaginated(Pageable pageRequest, CourseSearchDto criteria, Boolean markedAsDeleted);


    @Modifying
    @Query(value = """
                       UPDATE course
                          SET status_id = :statusId
                          WHERE id = :id
                       AND marked_as_deleted=false
            """, nativeQuery = true)
    void updateCourseStatus(Long id, Long statusId);


}
