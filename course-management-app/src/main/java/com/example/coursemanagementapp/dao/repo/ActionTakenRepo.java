package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ActionTaken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionTakenRepo extends JpaRepository<ActionTaken, Long> {

    ActionTaken findByAction(com.example.coursemanagementapp.enums.ActionTaken action);
}
