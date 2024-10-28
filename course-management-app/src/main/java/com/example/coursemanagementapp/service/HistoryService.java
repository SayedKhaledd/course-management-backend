package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.service.AbstractService;
import com.example.coursemanagementapp.dao.HistoryDao;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.model.History;
import com.example.coursemanagementapp.transformer.HistoryTransformer;

import java.util.List;

public interface HistoryService extends AbstractService<History, HistoryDto, HistoryTransformer, HistoryDao> {

    List<HistoryDto> findAllByEntityIdAndEntityTypeAndFieldName(Long entityId, String entityType, String fieldName);

    void deleteAllByEntityIdAndEntityType(Long entityId, String entityType);
}
