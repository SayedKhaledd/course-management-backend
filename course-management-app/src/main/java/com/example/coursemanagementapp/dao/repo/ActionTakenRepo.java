package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ActionTaken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActionTakenRepo extends JpaRepository<ActionTaken, Long> {

    List<ActionTaken> findAllByMarkedAsDeletedFalse();
}
