package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.EvaluationStatus;

import java.util.List;

@Repository
public interface EvaluationStatusRepo extends JpaRepository<EvaluationStatus, Long> {

    List<EvaluationStatus> findAllByMarkedAsDeletedFalse();
}
