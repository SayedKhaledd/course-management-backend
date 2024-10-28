package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.model.History;
import com.example.backendcoreservice.dao.AbstractDao;
import com.example.coursemanagementapp.dao.repo.HistoryRepo;

import java.util.List;

public interface HistoryDao extends AbstractDao<History, HistoryRepo> {

    List<History> findAllByEntityIdAndEntityTypeAndFieldName(Long entityId, String entityName, String fieldName);

    void deleteAllByEntityIdAndEntityType(Long entityId, String entityType);
}
