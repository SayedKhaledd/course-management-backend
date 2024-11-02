package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.CourseSearchDto;
import com.example.coursemanagementapp.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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


    @Modifying
    @Query(value = "UPDATE course SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);


    @Modifying
    @Query(value = "UPDATE course SET name = :name WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateName(Long id, String name);

    @Modifying
    @Query(value = "UPDATE course SET price = :price WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePrice(Long id, Double price);

    @Modifying
    @Query(value = "UPDATE course SET part = :part WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePart(Long id, String part);

    @Modifying
    @Query(value = "UPDATE course SET code = :code WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateCode(Long id, String code);

    @Modifying
    @Query(value = "UPDATE course SET description = :description WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateDescription(Long id, String description);

    @Modifying
    @Query(value = "UPDATE course SET start_date = :startDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateStartDate(Long id, LocalDateTime startDate);

    @Modifying
    @Query(value = "UPDATE course SET end_date = :endDate WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateEndDate(Long id, LocalDateTime endDate);



}
