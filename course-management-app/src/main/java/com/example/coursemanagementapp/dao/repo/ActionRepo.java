package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepo extends JpaRepository<Action, Long> {

}
