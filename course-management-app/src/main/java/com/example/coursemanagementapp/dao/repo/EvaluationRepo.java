package com.example.coursemanagementapp.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.coursemanagementapp.model.Evaluation;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

}
