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
