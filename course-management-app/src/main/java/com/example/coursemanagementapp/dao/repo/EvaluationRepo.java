package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

    @Query("SELECT e FROM Evaluation e WHERE e.enrollment.clientId = :clientId")
    List<Evaluation> findAllByClientId(Long clientId);

    @Query("SELECT e FROM Evaluation e WHERE e.enrollment.courseId = :courseId")
    List<Evaluation> findAllByCourseId(Long courseId);


    @Modifying
    @Query(value = "UPDATE evaluation SET modified_date = :currentDate, modified_by = :modifiedBy WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateModifiedDateAndModifiedBy(Long id, String modifiedBy, LocalDateTime currentDate);

    @Modifying
    @Query(value = "UPDATE evaluation SET exam_name = :examName WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateExamName(Long id, String examName);

    @Modifying
    @Query(value = "UPDATE evaluation SET evaluation_status_id = :evaluationStatusId WHERE id = :id AND marked_as_deleted = false", nativeQuery = true)
    void updateEvaluationStatus(Long id, Long evaluationStatusId);
}
