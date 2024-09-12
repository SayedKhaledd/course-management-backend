package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ClientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientHistoryRepo extends JpaRepository<ClientHistory, Long> {

}
