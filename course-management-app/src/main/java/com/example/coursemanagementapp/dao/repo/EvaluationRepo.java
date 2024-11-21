package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.dto.search.EvaluationSearchDto;
import com.example.coursemanagementapp.model.Evaluation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

   @Query("""
            SELECT e FROM Evaluation e
            WHERE
           (:#{#criteria.examName} IS NULL OR e.examName LIKE %:#{#criteria.examName}%)
           AND (:#{#criteria.evaluationStatusIds} IS NULL OR e.evaluationStatus.id IN :#{#criteria.evaluationStatusIds})
           AND (:#{#criteria.enrollmentId} IS NULL OR e.enrollment.id = :#{#criteria.enrollmentId})
           AND (:#{#criteria.clientId} IS NULL OR e.enrollment.client.id = :#{#criteria.clientId})
           AND (:#{#criteria.clientName} IS NULL OR e.enrollment.client.name LIKE CONCAT('%', :#{#criteria.clientName}, '%'))
           AND (:#{#criteria.courseCode} IS NULL OR e.enrollment.course.code LIKE CONCAT('%', :#{#criteria.courseCode}, '%'))
           AND (:#{#criteria.courseName} IS NULL OR e.enrollment.course.name LIKE CONCAT('%', :#{#criteria.courseName}, '%'))
           AND (:#{#criteria.createdBy} IS NULL OR e.createdBy LIKE CONCAT('%', :#{#criteria.createdBy}, '%'))
           AND (:#{#criteria.modifiedBy} IS NULL OR e.modifiedBy LIKE CONCAT('%', :#{#criteria.modifiedBy}, '%'))
           AND (:#{#criteria.createdDate} IS NULL OR CAST(e.createdDate AS string) LIKE CONCAT('%', :#{#criteria.createdDate}, '%'))
           AND (:#{#criteria.modifiedDate} IS NULL OR CAST(e.modifiedDate AS string) LIKE CONCAT('%', :#{#criteria.modifiedDate}, '%'))     
           """)
    Page<Evaluation> findAllFilteredAndPaginated(Pageable pageRequest, EvaluationSearchDto criteria);


}
