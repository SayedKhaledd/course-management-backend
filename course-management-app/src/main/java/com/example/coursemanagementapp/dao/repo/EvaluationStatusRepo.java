package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.EvaluationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationStatusRepo extends JpaRepository<EvaluationStatus, Long> {

}
