package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {


    @Query(value = "SELECT c from Course  c WHERE c.code!= 'N/A' ")
    List<Course> findAllCoursesNotInitial();

    @Query(value = "SELECT c from Course  c WHERE c.code= 'N/A' ")
    List<Course> findAllInitialCourses();


    @Query("""
               SELECT c
               FROM Course c
               WHERE
                   (:#{#criteria.name} IS NULL OR c.name LIKE CONCAT('%', :#{#criteria.name}, '%'))
                   AND (:#{#criteria.code} IS NULL OR c.code LIKE CONCAT('%', :#{#criteria.code}, '%'))
                   AND (:#{#criteria.isInitial} IS NULL OR (:#{#criteria.isInitial} = true AND c.code = 'N/A') OR (:#{#criteria.isInitial} = false AND c.code != 'N/A'))
                   AND (:#{#criteria.part} IS NULL OR c.part LIKE CONCAT('%', :#{#criteria.part}, '%'))
                   AND (:#{#criteria.description} IS NULL OR c.description LIKE CONCAT('%', :#{#criteria.description}, '%'))
                   AND (:#{#criteria.startDate} IS NULL OR CAST(c.createdDate AS string) LIKE CONCAT('%', :#{#criteria.startDate}, '%'))
                   AND (:#{#criteria.endDate} IS NULL OR CAST(c.createdDate AS string) LIKE CONCAT('%', :#{#criteria.endDate}, '%'))
                   AND (:#{#criteria.price} IS NULL OR c.price = :#{#criteria.price})
                   AND (:#{#criteria.courseStatusIds} IS NULL OR c.courseStatusId IN :#{#criteria.courseStatusIds})
                   AND (:#{#criteria.createdBy} IS NULL OR c.createdBy LIKE CONCAT('%', :#{#criteria.createdBy}, '%'))
                   AND (:#{#criteria.modifiedBy} IS NULL OR c.modifiedBy LIKE CONCAT('%', :#{#criteria.modifiedBy}, '%'))
                   AND (:#{#criteria.createdDate} IS NULL OR CAST(c.createdDate AS string) LIKE CONCAT('%', :#{#criteria.createdDate}, '%'))
                   AND (:#{#criteria.modifiedDate} IS NULL OR CAST(c.modifiedDate AS string) LIKE CONCAT('%', :#{#criteria.modifiedDate}, '%'))
            """)
    Page<Course> findAllFilteredAndPaginated(Pageable pageRequest, CourseSearchDto criteria);

}
