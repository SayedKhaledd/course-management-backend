package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.InstallmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.EvaluationHistory;

import java.util.List;

@Repository
public interface EvaluationHistoryRepo extends JpaRepository<EvaluationHistory, Long> {

    List<EvaluationHistory> findAllByEvaluationIdAndFieldName(Long evaluationId, String fieldName);

}
