package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.CourseLecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CourseLecturerRepo extends JpaRepository<CourseLecturer, Long> {


    @Modifying
    @Query(value = "UPDATE course_lecturer SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = "UPDATE course_lecturer SET paid_in_percentage = :paidInPercentage WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePaidInPercentage(Long id, Boolean paidInPercentage);

    @Modifying
    @Query(value = "UPDATE course_lecturer SET percentage_value = :percentage WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updatePercentage(Long id, Double percentage);

    @Modifying
    @Query(value = "UPDATE course_lecturer SET fixed_value = :fixedValue WHERE id = :id and marked_as_deleted=false ", nativeQuery = true)
    void updateFixedValue(Long id, Double fixedValue);

    List<CourseLecturer> findAllByCourseId(Long courseId);
}
