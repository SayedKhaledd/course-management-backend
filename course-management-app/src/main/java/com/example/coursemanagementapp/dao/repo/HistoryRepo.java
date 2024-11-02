package com.example.coursemanagementapp.dao.repo;

import com.example.coursemanagementapp.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepo extends JpaRepository<History, Long> {

    List<History> findAllByEntityIdAndEntityTypeAndFieldName(Long entityId, String entityType, String fieldName);

    void deleteAllByEntityIdAndEntityType(Long entityId, String entityType);
}
