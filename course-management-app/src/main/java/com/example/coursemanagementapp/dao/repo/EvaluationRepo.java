package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepo extends JpaRepository<Evaluation, Long> {

}
