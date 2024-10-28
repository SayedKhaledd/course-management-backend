package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dao.HistoryDao;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.model.History;
import com.example.coursemanagementapp.transformer.HistoryTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao;
    private final HistoryTransformer historyTransformer;

    @Override
    public HistoryDao getDao() {
        return historyDao;
    }

    @Override
    public HistoryTransformer getTransformer() {
        return historyTransformer;
    }

    @Override
    public String getEntityName() {
        return History.class.getSimpleName();
    }

    @Override
    public List<HistoryDto> findAllByEntityIdAndEntityTypeAndFieldName(Long entityId, String entityType, String fieldName) {
        log.info("HistoryServiceImpl: findAllByEntityIdAndEntityNameAndFieldName() - was called");
        return getTransformer().transformEntitiesToDtos(getDao().findAllByEntityIdAndEntityTypeAndFieldName(entityId, entityType, fieldName));
    }

    @Override
    public void deleteAllByEntityIdAndEntityType(Long entityId, String entityType) {
        log.info("HistoryServiceImpl: deleteAllByEntityIdAndEntityType() - was called");
        getDao().deleteAllByEntityIdAndEntityType(entityId, entityType);
    }


}
