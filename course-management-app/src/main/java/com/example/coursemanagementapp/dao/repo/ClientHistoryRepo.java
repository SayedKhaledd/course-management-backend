package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.ClientHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientHistoryRepo extends JpaRepository<ClientHistory, Long> {

    List<ClientHistory> findAllByClientId(Long clientId);

    List<ClientHistory> findAllByFieldName(String fieldName);
}
