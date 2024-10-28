package com.example.coursemanagementapp.dao;

import com.example.coursemanagementapp.dao.repo.HistoryRepo;
import com.example.coursemanagementapp.model.History;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class HistoryDaoImpl implements HistoryDao {

    private final HistoryRepo historyRepo;

    @Override
    public HistoryRepo getRepo() {
        return historyRepo;
    }

    @Override
    public List<History> findAllByEntityIdAndEntityTypeAndFieldName(Long entityId, String entityType, String fieldName) {
        log.info("HistoryDaoImpl: findAllByEntityIdAndEntityTypeAndFieldName() - was called");
        return getRepo().findAllByEntityIdAndEntityTypeAndFieldName(entityId, entityType, fieldName);
    }

    @Override
    public void deleteAllByEntityIdAndEntityType(Long entityId, String entityType) {
        log.info("HistoryDaoImpl: deleteAllByEntityIdAndEntityType() - was called");
        getRepo().deleteAllByEntityIdAndEntityType(entityId, entityType);
    }
}
